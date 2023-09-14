package com.proyectoIntegrador.dentalClinic.service.impl;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo.OdontologoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;
import com.proyectoIntegrador.dentalClinic.entity.Odontologo;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;
import com.proyectoIntegrador.dentalClinic.repository.OdontologoRepository;
import com.proyectoIntegrador.dentalClinic.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OdontologoService implements IOdontologoService {

    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);
    private final OdontologoRepository odontologoRepository;
    private final ModelMapper modelMapper;

    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
    }


    // ver video s23 y 24 minuto 1:52

    public OdontologoSalidaDto guardarOdontologo(OdontologoEntradaDto odontologo) {
        Odontologo odGuardado = odontologoRepository.save(dtoEntradaAOdontologo(odontologo));
        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odGuardado, OdontologoSalidaDto.class);
        LOGGER.info("Odontologo guardado: {}", odontologoSalidaDto);
        return odontologoSalidaDto;
    }

    // seguir viendo video en minuto 31 de s19 y s20
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {
        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);

        OdontologoSalidaDto odontologoSalidaDto = null;
        if (odontologoBuscado != null) {
            odontologoSalidaDto = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
            LOGGER.info("Odontologo encontrado: {}", odontologoSalidaDto);
        } else LOGGER.error("El id no se encuentra registrado en la base de datos");

        return odontologoSalidaDto;
    }

    public List<OdontologoSalidaDto> listarOdontologos() {
        List<OdontologoSalidaDto> odontologos = odontologoRepository.findAll().stream()
                .map(o -> modelMapper.map(o, OdontologoSalidaDto.class)).toList();

        LOGGER.info("Listado de todos los odontologos: {}", odontologos);

        return odontologos;
    }

    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (buscarOdontologoPorId(id) != null) {
            odontologoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el odontologo con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el odontologo con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el odontologo con id " + id);
        }
    }

    @Override
    public OdontologoSalidaDto modificarOdontologo(OdontologoModificacionEntradaDto modificarOdontologo) throws ResourceNotFoundException {
        Odontologo odontologoRecibido = modelMapper.map(modificarOdontologo, Odontologo.class);
        Odontologo odontologoAActualizar = odontologoRepository.findById(modificarOdontologo.getId()).orElse(null);
        OdontologoSalidaDto odontologoSalidaDto = null;

        if (odontologoAActualizar != null) {

            odontologoAActualizar = odontologoRecibido;
            odontologoRepository.save(odontologoAActualizar);

            odontologoSalidaDto = modelMapper.map(odontologoAActualizar, OdontologoSalidaDto.class);

            LOGGER.warn("Odontologo actualizado: {}", odontologoSalidaDto);

        } else {
            LOGGER.error("No fue posible actualizar los datos ya que el odontologo no se encuentra registrado");
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id" + modificarOdontologo.getId());
        }


        return odontologoSalidaDto;
    }

    public Odontologo dtoEntradaAOdontologo(OdontologoEntradaDto odontologoEntradaDto) {
        return modelMapper.map(odontologoEntradaDto, Odontologo.class);
    }

    public OdontologoSalidaDto odontologoADtoSalida(Odontologo odontologo) {

        return modelMapper.map(odontologo, OdontologoSalidaDto.class);
    }

    public Odontologo dtoModificadoAOdontologo(OdontologoModificacionEntradaDto odontologEntradaDto) {
        return modelMapper.map(odontologEntradaDto, Odontologo.class);
    }


}
