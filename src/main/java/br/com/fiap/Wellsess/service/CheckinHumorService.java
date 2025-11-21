package br.com.fiap.Wellsess.service;

import br.com.fiap.Wellsess.dto.CheckinHumorRequestDTO;
import br.com.fiap.Wellsess.dto.CheckinHumorResponseDTO;
import br.com.fiap.Wellsess.entity.CheckinHumor;
import br.com.fiap.Wellsess.entity.Usuario;
import br.com.fiap.Wellsess.repository.CheckinHumorRepository;
import br.com.fiap.Wellsess.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckinHumorService {

    @Autowired
    private CheckinHumorRepository checkinHumorRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager entityManager;

    public List<CheckinHumorResponseDTO> findAll() {
        return checkinHumorRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CheckinHumorResponseDTO findById(Long id) {
        CheckinHumor checkin = checkinHumorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkin não encontrado"));
        return toResponseDTO(checkin);
    }

    public List<CheckinHumorResponseDTO> findByUsuarioId(Long usuarioId) {
        return checkinHumorRepository.findByUsuarioId(usuarioId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CheckinHumorResponseDTO create(CheckinHumorRequestDTO dto) {
        if (!usuarioRepository.existsById(dto.getUsuarioId())) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Long proximoId = buscarProximoIdCheckin();
        java.sql.Date dataCheckinSql = java.sql.Date.valueOf(dto.getDataCheckin());
        checkinHumorRepository.inserirCheckinHumor(proximoId, dataCheckinSql, dto.getNivelHumor(), dto.getComentario(), dto.getUsuarioId());
        CheckinHumor checkin = checkinHumorRepository.findById(proximoId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar checkin"));

        return toResponseDTO(checkin);
    }

    public CheckinHumorResponseDTO update(Long id, CheckinHumorRequestDTO dto) {
        CheckinHumor checkin = checkinHumorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checkin não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        checkin.setDataCheckin(dto.getDataCheckin());
        checkin.setNivelHumor(dto.getNivelHumor());
        checkin.setComentario(dto.getComentario());
        checkin.setUsuario(usuario);

        CheckinHumor updated = checkinHumorRepository.save(checkin);
        return toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!checkinHumorRepository.existsById(id)) {
            throw new RuntimeException("Checkin não encontrado");
        }
        checkinHumorRepository.deleteById(id);
    }

    private Long buscarProximoIdCheckin() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_CHECKIN), 0) + 1 FROM ARM_CHECKIN_HUMOR");
        return ((Number) query.getSingleResult()).longValue();
    }

    private CheckinHumorResponseDTO toResponseDTO(CheckinHumor checkin) {
        return new CheckinHumorResponseDTO(
                checkin.getId(),
                checkin.getDataCheckin(),
                checkin.getNivelHumor(),
                checkin.getComentario(),
                checkin.getUsuario().getId()
        );
    }
}
