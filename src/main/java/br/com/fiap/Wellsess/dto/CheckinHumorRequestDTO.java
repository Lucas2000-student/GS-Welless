package br.com.fiap.Wellsess.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class CheckinHumorRequestDTO {

    @NotNull(message = "Data do checkin é obrigatória")
    @PastOrPresent(message = "Data do checkin não pode ser futura")
    private LocalDate dataCheckin;

    @NotNull(message = "Nível de humor é obrigatório")
    @Min(value = 1, message = "Nível de humor deve ser no mínimo 1")
    @Max(value = 10, message = "Nível de humor deve ser no máximo 10")
    private Integer nivelHumor;

    @Size(max = 100, message = "Comentário deve ter no máximo 100 caracteres")
    private String comentario;

    @NotNull(message = "ID do usuário é obrigatório")
    private Long usuarioId;

    // constructors, getters and setters
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
