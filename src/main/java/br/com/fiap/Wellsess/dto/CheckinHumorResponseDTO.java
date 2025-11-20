package br.com.fiap.Wellsess.dto;

import java.time.LocalDate;

public class CheckinHumorResponseDTO {
    private Long id;
    private LocalDate dataCheckin;
    private Integer nivelHumor;
    private String comentario;
    private Long usuarioId;

    public CheckinHumorResponseDTO() {}

    public CheckinHumorResponseDTO(Long id, LocalDate dataCheckin, Integer nivelHumor, String comentario, Long usuarioId) {
        this.id = id;
        this.dataCheckin = dataCheckin;
        this.nivelHumor = nivelHumor;
        this.comentario = comentario;
        this.usuarioId = usuarioId;
    }

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
