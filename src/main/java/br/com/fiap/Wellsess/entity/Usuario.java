package br.com.fiap.Wellsess.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ARM_USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NOME_USUARIO", length = 50)
    private String nome;

    @Column(name = "EMAIL_USUARIO", length = 50)
    private String email;

    @Column(name = "SENHA_USUARIO", length = 50)
    private String senha;

    @Column(name = "DATA_CADASTRO")
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "usuario")
    private List<CheckinHumor> checkins;

    @OneToMany(mappedBy = "usuario")
    private List<Setor> setores;

    @OneToMany(mappedBy = "usuario")
    private List<Gestao> gestores;

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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<CheckinHumor> getCheckins() {
        return checkins;
    }

    public void setCheckins(List<CheckinHumor> checkins) {
        this.checkins = checkins;
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public void setSetores(List<Setor> setores) {
        this.setores = setores;
    }

    public List<Gestao> getGestores() {
        return gestores;
    }

    public void setGestores(List<Gestao> gestores) {
        this.gestores = gestores;
    }
}

