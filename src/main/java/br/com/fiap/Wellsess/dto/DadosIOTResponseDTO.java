package br.com.fiap.Wellsess.dto;

import java.time.LocalDate;

public class DadosIOTResponseDTO {
    private Long id;
    private LocalDate dataColeta;
    private String temperatura;
    private String localSensor;
    private Long checkinId;

    public DadosIOTResponseDTO() {}

    public DadosIOTResponseDTO(Long id, LocalDate dataColeta, String temperatura, String localSensor, Long checkinId) {
        this.id = id;
        this.dataColeta = dataColeta;
        this.temperatura = temperatura;
        this.localSensor = localSensor;
        this.checkinId = checkinId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(LocalDate dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getLocalSensor() {
        return localSensor;
    }

    public void setLocalSensor(String localSensor) {
        this.localSensor = localSensor;
    }

    public Long getCheckinId() {
        return checkinId;
    }

    public void setCheckinId(Long checkinId) {
        this.checkinId = checkinId;
    }
}