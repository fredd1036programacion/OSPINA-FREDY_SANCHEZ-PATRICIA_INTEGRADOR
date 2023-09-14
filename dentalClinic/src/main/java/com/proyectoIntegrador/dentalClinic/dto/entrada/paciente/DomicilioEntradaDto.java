package com.proyectoIntegrador.dentalClinic.dto.entrada.paciente;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


// si hay algun campo esta demas que se ingore.
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioEntradaDto {

    @NotNull(message = "no debe ser nula la calle")
    @NotBlank(message = "debe especificar el nombre de la calle")
    private String calle;

    //@Digits(integer = 8, fraction = 0, message = "El número debe tener como máximo 8 dígitos")
    @Pattern(regexp = "\\d{1,8}", message = "El número debe tener como máximo 8 dígitos")
    @NotNull(message = "no debe ser nula la numero")
    @NotBlank(message = "debe especificar el nombre de la numero")
    private int numero;
    @NotNull(message = "no debe ser nula la localidad")
    @NotBlank(message = "debe especificar el nombre de la localidad")
    private String localidad;
    @NotNull(message = "no debe ser nula la Provincia")
    @NotBlank(message = "debe especificar el nombre de la provincia")
    private String provincia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


}
