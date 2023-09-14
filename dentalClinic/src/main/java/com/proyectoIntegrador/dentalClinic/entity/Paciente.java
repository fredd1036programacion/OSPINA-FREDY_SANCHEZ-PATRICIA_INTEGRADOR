package com.proyectoIntegrador.dentalClinic.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PACIENTES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"dni"})
})
public class Paciente {

    @Id
    //id auto incremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 50)
    private Long id;
    @Column(length = 50)
    private String nombre;
    private String apellido;
    private int dni;

    //se usa si en el front el campo que nos llega en el JSon tiene un nombre diferente a mi atributo, asi con ese @ puedo indicarle a que campo quiero que direcciones el dato que viene del JSon
    //@JsonProperty("fechaingreso")
    private LocalDate fechaIngreso;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "domilicio_id")
    private Domicilio domicilio;

    public Paciente() {
    }


    public Paciente(String nombre, String apellido, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
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

    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre + " - Apellido: " + apellido + " - DNI: " + dni + " - Fechas de ingreso: " + fechaIngreso + " - Domicilio: " + domicilio;
    }
}
