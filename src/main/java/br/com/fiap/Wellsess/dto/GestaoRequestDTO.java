package br.com.fiap.Wellsess.dto;

import jakarta.validation.constraints.*;

public class GestaoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 50, message = "Nome deve ter entre 2 e 50 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Size(max = 50, message = "Email deve ter no máximo 50 caracteres")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 50, message = "Senha deve ter entre 6 e 50 caracteres")
    private String senha;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;

    // constructors, getters and setters
    public GestaoRequestDTO() {}

    public GestaoRequestDTO(String nome, String email, String senha, Long usuarioId) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
