package br.com.fiap.Wellsess.service;

import br.com.fiap.Wellsess.dto.GestaoRequestDTO;
import br.com.fiap.Wellsess.dto.GestaoResponseDTO;
import br.com.fiap.Wellsess.entity.Gestao;
import br.com.fiap.Wellsess.entity.Usuario;
import br.com.fiap.Wellsess.repository.GestaoRepository;
import br.com.fiap.Wellsess.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestaoService {

    @Autowired
    private GestaoRepository gestaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager entityManager;

    public List<GestaoResponseDTO> findAll() {
        return gestaoRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public GestaoResponseDTO findById(Long id) {
        Gestao gestao = gestaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gestor não encontrado"));
        return toResponseDTO(gestao);
    }

    public GestaoResponseDTO create(GestaoRequestDTO dto) {
        if (gestaoRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (!usuarioRepository.existsById(dto.getUsuarioId())) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Long proximoId = buscarProximoIdGestao();

        gestaoRepository.inserirGestor(proximoId, dto.getNome(), dto.getEmail(), dto.getSenha(), dto.getUsuarioId());

        Gestao gestao = gestaoRepository.findById(proximoId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar gestor"));

        return toResponseDTO(gestao);
    }

    public GestaoResponseDTO update(Long id, GestaoRequestDTO dto) {
        Gestao gestao = gestaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gestor não encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        gestao.setNome(dto.getNome());
        gestao.setEmail(dto.getEmail());
        gestao.setSenha(dto.getSenha());
        gestao.setUsuario(usuario);

        Gestao updated = gestaoRepository.save(gestao);
        return toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!gestaoRepository.existsById(id)) {
            throw new RuntimeException("Gestor não encontrado");
        }
        gestaoRepository.deleteById(id);
    }

    private Long buscarProximoIdGestao() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_GESTOR), 0) + 1 FROM ARM_GESTAO");
        return ((Number) query.getSingleResult()).longValue();
    }

    private GestaoResponseDTO toResponseDTO(Gestao gestao) {
        return new GestaoResponseDTO(
                gestao.getId(),
                gestao.getNome(),
                gestao.getEmail(),
                gestao.getUsuario().getId()
        );
    }
}