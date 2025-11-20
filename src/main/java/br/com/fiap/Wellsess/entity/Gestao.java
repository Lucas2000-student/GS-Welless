package br.com.fiap.Wellsess.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ARM_GESTAO")
public class Gestao {

    @Id
    @Column(name = "ID_GESTOR")
    private Long id;

    @Column(name = "NOME_GESTOR", length = 50)
    private String nome;

    @Column(name = "EMAIL_GESTOR", length = 50)
    private String email;

    @Column(name = "SENHA_GESTOR", length = 50)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @OneToMany(mappedBy = "gestor")
    private List<Setor> setores;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }
}

