package br.com.fiap.Wellsess.dto;

public class GestaoResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Long usuarioId;

    public GestaoResponseDTO() {}

    public GestaoResponseDTO(Long id, String nome, String email, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
