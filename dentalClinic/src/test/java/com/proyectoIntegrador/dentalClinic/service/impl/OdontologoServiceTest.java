package com.proyectoIntegrador.dentalClinic.service.impl;

import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo.OdontologoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.DomicilioEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.PacienteEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;




    @SpringBootTest
    @TestPropertySource(locations = "classpath:application-test.properties")
    class OdontologoServiceTest {

        @Autowired
        private OdontologoService odontologoService;

        @Test
        @Order(1)
        void deberiaInsertarUnOdontolgoDeNombreFredyConId1(){
            OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("AB-21242531","Fredy","Soto");

            OdontologoSalidaDto odontologoSalidaDto = odontologoService.guardarOdontologo(odontologoEntradaDto);

           assertEquals("Fredy", odontologoEntradaDto.getNombre());
           assertEquals(1, odontologoSalidaDto.getId());
        }

       @Test
        @Order(2)
        void deberiaRetornarseUnaListaNoVaciaDeOdontologos(){
            assertTrue(odontologoService.listarOdontologos().size() > 0);
        }

       @Test
        @Order(3)
        void alIntentarActualizarElOdontologId2_deberiaLanzarseUnaResourceNotFoundException(){
            OdontologoModificacionEntradaDto odontologoModificacionEntradaDto = new OdontologoModificacionEntradaDto();
            odontologoModificacionEntradaDto.setId(2L);
            assertThrows(ResourceNotFoundException.class, () -> odontologoService.modificarOdontologo(odontologoModificacionEntradaDto));
        }

        @Test
        @Order(4)
        void alIntentarEliminarUnOdontologYaEliminado_deberiaLanzarseUnResourceNotFoundException(){
            try{
                odontologoService.eliminarOdontologo(2L);
            } catch (Exception e){
                e.printStackTrace();
            }
            assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(2L));
        }



    }