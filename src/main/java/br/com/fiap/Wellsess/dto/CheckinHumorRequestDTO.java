package br.com.fiap.Wellsess.dto;

import java.time.LocalDate;

public class CheckinHumorRequestDTO {
    private LocalDate dataCheckin;
    private Integer nivelHumor;
    private String comentario;
    private Long usuarioId;


    public CheckinHumorRequestDTO() {}

    public CheckinHumorRequestDTO(LocalDate dataCheckin, Integer nivelHumor, String comentario, Long usuarioId) {
        this.dataCheckin = dataCheckin;
        this.nivelHumor = nivelHumor;
        this.comentario = comentario;
        this.usuarioId = usuarioId;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
