package br.com.fiap.Wellsess.service;

import br.com.fiap.Wellsess.dto.LoginRequestDTO;
import br.com.fiap.Wellsess.dto.LoginResponseDTO;
import br.com.fiap.Wellsess.dto.UsuarioRequestDTO;
import br.com.fiap.Wellsess.dto.UsuarioResponseDTO;
import br.com.fiap.Wellsess.entity.Usuario;
import br.com.fiap.Wellsess.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager entityManager;

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        try {
            Usuario usuario = usuarioRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            if (usuario.getSenha().equals(loginRequest.getSenha())) {

                return new LoginResponseDTO(true, "Login realizado com sucesso", toResponseDTO(usuario));
            } else {
                return new LoginResponseDTO(false, "Senha incorreta");
            }
        } catch (RuntimeException e) {
            return new LoginResponseDTO(false, "Credenciais inválidas");
        }
    }

    public LoginResponseDTO login(String email, String senha) {
        LoginRequestDTO loginRequest = new LoginRequestDTO(email, senha);
        return login(loginRequest);
    }

    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(this::toResponseDTO);
    }

    public Page<UsuarioResponseDTO> findByNome(String nome, Pageable pageable) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome, pageable)
                .map(this::toResponseDTO);
    }

    public Page<UsuarioResponseDTO> findByEmail(String email, Pageable pageable) {
        return usuarioRepository.findByEmailContainingIgnoreCase(email, pageable)
                .map(this::toResponseDTO);
    }

    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO create(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Long proximoId = buscarProximoIdUsuario();
        java.sql.Date dataCadastroSql = java.sql.Date.valueOf(dto.getDataCadastro());

        usuarioRepository.inserirUsuario(proximoId, dto.getNome(), dto.getEmail(), dto.getSenha(), dataCadastroSql);

        Usuario usuario = usuarioRepository.findById(proximoId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar usuário"));

        return toResponseDTO(usuario);
    }

    public UsuarioResponseDTO update(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        Usuario updated = usuarioRepository.save(usuario);
        return toResponseDTO(updated);
    }

    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    private Long buscarProximoIdUsuario() {
        Query query = entityManager.createNativeQuery("SELECT NVL(MAX(ID_USUARIO), 0) + 1 FROM ARM_USUARIO");
        return ((Number) query.getSingleResult()).longValue();
    }

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataCadastro()
        );
    }
}