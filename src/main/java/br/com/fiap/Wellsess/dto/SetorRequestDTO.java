package br.com.fiap.Wellsess.dto;

public class SetorRequestDTO {
    private String nome;
    private Integer quantidadeFuncionarios;
    private Long gestorId;
    private Long usuarioId;

    public SetorRequestDTO() {}

    public SetorRequestDTO(String nome, Integer quantidadeFuncionarios, Long gestorId, Long usuarioId) {
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        this.gestorId = gestorId;
        this.usuarioId = usuarioId;
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
        return gestorId;
    }

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
