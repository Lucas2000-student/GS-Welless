package br.com.fiap.Wellsess.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ARM_DADOS_IOT")
public class DadosIOT {

    @Id
    @Column(name = "ID_DADOS_IOT")
    private Long id;

    @Column(name = "DATA_COLETA")
    private LocalDate dataColeta;

    @Column(name = "TEMPERATURA_AMBIENTE", length = 10)
    private String temperatura;

    @Column(name = "LOCAL_SENSOR", length = 10)
    private String localSensor;

    @ManyToOne
    @JoinColumn(name = "ID_CHECKIN")
    private CheckinHumor checkin;

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

    public CheckinHumor getCheckin() {
        return checkin;
    }

    public void setCheckin(CheckinHumor checkin) {
        this.checkin = checkin;
    }
}


