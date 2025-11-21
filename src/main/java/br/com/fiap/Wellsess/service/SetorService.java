package br.com.fiap.Wellsess.service;

import br.com.fiap.Wellsess.dto.SetorRequestDTO;
import br.com.fiap.Wellsess.dto.SetorResponseDTO;
import br.com.fiap.Wellsess.entity.Setor;
import br.com.fiap.Wellsess.entity.Gestao;
import br.com.fiap.Wellsess.entity.Usuario;
import br.com.fiap.Wellsess.repository.SetorRepository;
import br.com.fiap.Wellsess.repository.GestaoRepository;
import br.com.fiap.Wellsess.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private GestaoRepository gestaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager entityManager;

    public List<SetorResponseDTO> findAll() {
        return setorRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public SetorResponseDTO findById(Long id) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
        return toResponseDTO(setor);
    }

    public SetorResponseDTO create(SetorRequestDTO dto) {
        if (!gestaoRepository.existsById(dto.getGestorId())) {
            throw new RuntimeException("Gestor não encontrado");
        }

        if (!usuarioRepository.existsById(dto.getUsuarioId())) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Long proximoId = buscarProximoIdSetor();

        setorRepository.inserirSetor(proximoId, dto.getNome(), dto.getQuantidadeFuncionarios(), dto.getGestorId(), dto.getUsuarioId());

        Setor setor = setorRepository.findById(proximoId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar setor"));

        return toResponseDTO(setor);
    }

    public SetorResponseDTO update(Long id, SetorRequestDTO dto) {
        Setor setor = setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        Gestao gestor = gestaoRepository.findById(dto.getGestorId())
                .orElseThrow(() -> new RuntimeException("Gestor não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        setor.setNome(dto.getNome());
        setor.setQuantidadeFuncionarios(dto.getQuantidadeFuncionarios());
        setor.setGestor(gestor);
        setor.setUsuario(usuario);

        Setor updated = setorRepository.save(setor);
        return toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!setorRepository.existsById(id)) {
            throw new RuntimeException("Setor não encontrado");
        }
        setorRepository.deleteById(id);
    }

    private Long buscarProximoIdSetor() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_SETOR), 0) + 1 FROM ARM_SETOR");
        return ((Number) query.getSingleResult()).longValue();
    }

    private SetorResponseDTO toResponseDTO(Setor setor) {
        return new SetorResponseDTO(
                setor.getId(),
                setor.getNome(),
                setor.getQuantidadeFuncionarios(),
                setor.getGestor().getId(),
                setor.getUsuario().getId()
        );
    }
}
