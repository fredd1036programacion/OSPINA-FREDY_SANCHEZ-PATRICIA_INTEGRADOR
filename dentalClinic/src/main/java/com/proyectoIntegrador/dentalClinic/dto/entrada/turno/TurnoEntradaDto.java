package com.proyectoIntegrador.dentalClinic.dto.entrada.turno;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoEntradaDto {

    //solo necesito los id de los pacientes y odontologos por que solo me interesa que existan
    @NotNull(message = "El paciente debe estar diligenciado")
    private Long odontologoId;

    @NotNull(message = "El odontologo debe estar diligenciado")
    private Long pacienteId;

    //se va a usar LocakDateTime para que se pueda regitrar la fecha y la hora tambien
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent(message = "La fecha no puede ser anterior al dia de hoy")
    @NotNull(message = "Debe especificarse la fecha y la hora del turno")
    private LocalDateTime fechaYHora;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(Long odontologoId, Long pacienteId, LocalDateTime fechaYHora) {
        this.odontologoId = odontologoId;
        this.pacienteId = pacienteId;
        this.fechaYHora = fechaYHora;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
