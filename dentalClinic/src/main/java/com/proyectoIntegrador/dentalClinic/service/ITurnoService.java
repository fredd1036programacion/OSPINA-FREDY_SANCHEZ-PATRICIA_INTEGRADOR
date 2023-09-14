package com.proyectoIntegrador.dentalClinic.service;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.turno.TurnoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.turno.TurnoSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.BadRequestException;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException;

    List<TurnoSalidaDto> listarTurno();

    TurnoSalidaDto buscarTurnoPorId(Long id);

    void eliminarTurno(Long id) throws ResourceNotFoundException;

    //Terminar la modificacion solicitada por la profe

    TurnoSalidaDto modificarTurno(TurnoModificacionEntradaDto turnoModificado) throws ResourceNotFoundException;
}
