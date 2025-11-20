package br.com.fiap.Wellsess.dto;

import java.time.LocalDate;

public class UsuarioRequestDTO {
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataCadastro;

    public UsuarioRequestDTO() {}

    public UsuarioRequestDTO(String nome, String email, String senha, LocalDate dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCadastro = dataCadastro;
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
}
