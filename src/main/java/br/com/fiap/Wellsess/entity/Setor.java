package br.com.fiap.Wellsess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ARM_SETOR")
public class Setor {

    @Id
    @Column(name = "ID_SETOR")
    private Long id;

    @Column(name = "NOME_SETOR", length = 15)
    private String nome;

    @Column(name = "QUANTIDADE_FUNC")
    private Integer quantidadeFuncionarios;

    @ManyToOne
    @JoinColumn(name = "ID_GESTOR_1")
    private Gestao gestor;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

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

    public Gestao getGestor() {
        return gestor;
    }

    public void setGestor(Gestao gestor) {
        this.gestor = gestor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

