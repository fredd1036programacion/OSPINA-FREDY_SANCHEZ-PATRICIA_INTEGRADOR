package com.proyectoIntegrador.dentalClinic.service.impl;

import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo.OdontologoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.DomicilioEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.PacienteEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.turno.TurnoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.turno.TurnoSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.BadRequestException;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private PacienteService pacienteService;




    @Test
    @Order(1)
    void deberiaInsertarUnTurnoDeNombreJuanConId1() throws BadRequestException {

        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Juan", "Perez", 111111, LocalDate.of(2023, 12, 9), new DomicilioEntradaDto("calle", 1232, "localidad", "provincia"));
        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AB-21242531","Fredy","Soto");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.guardarOdontologo(odontologoEntradaDto);


        TurnoEntradaDto turnoEntradaDto = new TurnoEntradaDto(1L,1L, LocalDateTime.parse("2025-12-01T05:30"));

        TurnoSalidaDto turnoSalidaDto = turnoService.registrarTurno(turnoEntradaDto);


        assertEquals(1, turnoSalidaDto.getId());
    }

    @Test
    @Order(2)
    void deberiaRetornarseUnaListaNoVaciaDeTurnos(){
        assertTrue(turnoService.listarTurno().size() > 0);
    }

    @Test
    @Order(3)
    void alIntentarActualizarElTurnoId2_deberiaLanzarseUnaResourceNotFoundException(){
        TurnoModificacionEntradaDto turnoModificacionEntradaDto = new TurnoModificacionEntradaDto();
        turnoModificacionEntradaDto.setId(2L);
        assertThrows(ResourceNotFoundException.class, () -> turnoService.modificarTurno(turnoModificacionEntradaDto));
    }

    @Test
    @Order(4)
    void alIntentarEliminarUnOdontologYaEliminado_deberiaLanzarseUnResourceNotFoundException(){
        try{
            turnoService.eliminarTurno(2L);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(2L));
    }



}