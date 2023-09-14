// estas salidas de odontologoturno y pacienteturno son para que en la salida turno tengamos informacion de los odontologos y pacientes ya que en el de entrada solo estamos trabajando con el id


package com.proyectoIntegrador.dentalClinic.dto.salida.turno;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoTurnoSalidaDto {

    private Long id;
    private String nombre;
    private String apellido;

    public OdontologoTurnoSalidaDto() {
    }

    public OdontologoTurnoSalidaDto(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre + " - Apellido: " + apellido;
    }
}
