package br.com.fiap.Wellsess.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "ARM_CHECKIN_HUMOR")
public class CheckinHumor {

    @Id
    @Column(name = "ID_CHECKIN")
    private Long id;

    @Column(name = "DATA_CHECKIN")
    private LocalDate dataCheckin;

    @Column(name = "NIVEL_HUMOR")
    private Integer nivelHumor;

    @Column(name = "COMENTARIO_CHECKIN", length = 100)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @OneToMany(mappedBy = "checkin")
    private List<DadosIOT> dados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public Integer getNivelHumor() {
        return nivelHumor;
    }

    public void setNivelHumor(Integer nivelHumor) {
        this.nivelHumor = nivelHumor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DadosIOT> getDados() {
        return dados;
    }

    public void setDados(List<DadosIOT> dados) {
        this.dados = dados;
    }
}

