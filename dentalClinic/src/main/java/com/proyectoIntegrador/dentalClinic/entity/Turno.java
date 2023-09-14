package com.proyectoIntegrador.dentalClinic.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TURNOS")
public class Turno {
    @Id
    //id auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    private Long id;
    //solo necesito los id de los pacientes y odontologos por que solo me interesa que existan
    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    //se va a usar LocakDateTime para que se pueda regitrar la fecha y la hora tambien
    private LocalDateTime fechaYHora;

    public Turno() {
    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime fechaYHora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechaYHora = fechaYHora;
    }

    public Long getId() {
        return id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
