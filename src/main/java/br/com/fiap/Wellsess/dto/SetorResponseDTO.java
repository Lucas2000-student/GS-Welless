package br.com.fiap.Wellsess.dto;

public class SetorResponseDTO {
    private Long id;
    private String nome;
    private Integer quantidadeFuncionarios;
    private Long gestorId;
    private Long usuarioId;

    public SetorResponseDTO() {}

    public SetorResponseDTO(Long id, String nome, Integer quantidadeFuncionarios, Long gestorId, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.gestorId = gestorId;
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

    public Integer getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public void setQuantidadeFuncionarios(Integer quantidadeFuncionarios) {
        this.quantidadeFuncionarios = quantidadeFuncionarios;

    }
    public Long getGestorId() {
        return gestorId; }

    public void setGestorId(Long gestorId) {
        this.gestorId = gestorId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}