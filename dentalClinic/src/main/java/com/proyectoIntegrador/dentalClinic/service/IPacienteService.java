package com.proyectoIntegrador.dentalClinic.service;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.PacienteEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    //metodos


    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    PacienteSalidaDto buscarPacientePorId(Long id);

    List<PacienteSalidaDto> listarPacientes();

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    // la clase paciente del inicio es el retorno, se espera que retorne un paciente
    PacienteSalidaDto modificarPaciente(PacienteModificacionEntradaDto pacienteModificado) throws ResourceNotFoundException;


}
