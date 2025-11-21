package br.com.fiap.Wellsess.dto;

import jakarta.validation.constraints.*;

public class SetorRequestDTO {

    @NotBlank(message = "Nome do setor é obrigatório")
    @Size(min = 2, max = 15, message = "Nome do setor deve ter entre 2 e 15 caracteres")
    private String nome;

    @NotNull(message = "Quantidade de funcionários é obrigatória")
    @Min(value = 1, message = "Quantidade de funcionários deve ser no mínimo 1")
    @Max(value = 999, message = "Quantidade de funcionários deve ser no máximo 999")
    private Integer quantidadeFuncionarios;

    @NotNull(message = "ID do gestor é obrigatório")
    private Long gestorId;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;

    // constructors, getters and setters
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
