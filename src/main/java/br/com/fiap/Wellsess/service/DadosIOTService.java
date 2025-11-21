package br.com.fiap.Wellsess.service;

import br.com.fiap.Wellsess.dto.DadosIOTRequestDTO;
import br.com.fiap.Wellsess.dto.DadosIOTResponseDTO;
import br.com.fiap.Wellsess.entity.DadosIOT;
import br.com.fiap.Wellsess.entity.CheckinHumor;
import br.com.fiap.Wellsess.repository.DadosIOTRepository;
import br.com.fiap.Wellsess.repository.CheckinHumorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DadosIOTService {

    @Autowired
    private DadosIOTRepository dadosIOTRepository;

    @Autowired
    private CheckinHumorRepository checkinHumorRepository;

    @Autowired
    private EntityManager entityManager;

    public List<DadosIOTResponseDTO> findAll() {
        return dadosIOTRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DadosIOTResponseDTO findById(Long id) {
        DadosIOT dados = dadosIOTRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dados IOT não encontrados"));
        return toResponseDTO(dados);
    }

    public List<DadosIOTResponseDTO> findByCheckinId(Long checkinId) {
        return dadosIOTRepository.findByCheckinId(checkinId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public DadosIOTResponseDTO create(DadosIOTRequestDTO dto) {
        if (!checkinHumorRepository.existsById(dto.getCheckinId())) {
            throw new RuntimeException("Checkin não encontrado");
        }

        Long proximoId = buscarProximoIdDadosIOT();
        java.sql.Date dataColetaSql = java.sql.Date.valueOf(dto.getDataColeta());

        dadosIOTRepository.inserirDadosIOT(proximoId, dataColetaSql, dto.getTemperatura(), dto.getLocalSensor(), dto.getCheckinId());

        DadosIOT dados = dadosIOTRepository.findById(proximoId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar dados IOT"));

        return toResponseDTO(dados);
    }

    public DadosIOTResponseDTO update(Long id, DadosIOTRequestDTO dto) {
        DadosIOT dados = dadosIOTRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dados IOT não encontrados"));

        CheckinHumor checkin = checkinHumorRepository.findById(dto.getCheckinId())
                .orElseThrow(() -> new RuntimeException("Checkin não encontrado"));

        dados.setDataColeta(dto.getDataColeta());
        dados.setTemperatura(dto.getTemperatura());
        dados.setLocalSensor(dto.getLocalSensor());
        dados.setCheckin(checkin);

        DadosIOT updated = dadosIOTRepository.save(dados);
        return toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!dadosIOTRepository.existsById(id)) {
            throw new RuntimeException("Dados IOT não encontrados");
        }
        dadosIOTRepository.deleteById(id);
    }

    private Long buscarProximoIdDadosIOT() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_DADOS_IOT), 0) + 1 FROM ARM_DADOS_IOT");
        return ((Number) query.getSingleResult()).longValue();
    }

    private DadosIOTResponseDTO toResponseDTO(DadosIOT dados) {
        return new DadosIOTResponseDTO(
                dados.getId(),
                dados.getDataColeta(),
                dados.getTemperatura(),
                dados.getLocalSensor(),
                dados.getCheckin().getId()
        );
    }
}