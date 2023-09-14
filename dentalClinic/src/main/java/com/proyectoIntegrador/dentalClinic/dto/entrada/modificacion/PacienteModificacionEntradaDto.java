package com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion;

import com.proyectoIntegrador.dentalClinic.entity.Domicilio;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PacienteModificacionEntradaDto {

    @NotNull
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private int dni;

    //se usa si en el front el campo que nos llega en el JSon tiene un nombre diferente a mi atributo, asi con ese @ puedo indicarle a que campo quiero que direcciones el dato que viene del JSon
    //@JsonProperty("fechaingreso")
    @NotNull
    private LocalDate fechaIngreso;
    @NotNull
    private Domicilio domicilio;

    public PacienteModificacionEntradaDto() {

    }

    public PacienteModificacionEntradaDto(Long id, String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
