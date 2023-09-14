package com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OdontologoEntradaDto {

    @NotNull(message = "el dato de matricula no puede ser nulo")
    @NotBlank(message = "el campo no puede estar vacio")
    @Pattern(regexp = "^[A-Z]{2}-\\d{1,3}\\d*$", message = "debe ser alfanumerico y un guion despues de las 2 letras")
    @Size(min = 10, message = "El campo debe tener mínimo 10 caracteres")
    private String matricula;

    @NotNull(message = "el nombre de odontologo no puede estar nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    private String nombre;
    @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del odontologo")
    private String apellido;

    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
