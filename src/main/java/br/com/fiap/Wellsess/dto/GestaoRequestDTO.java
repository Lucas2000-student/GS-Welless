package br.com.fiap.Wellsess.dto;

public class GestaoRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private Long usuarioId;

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
