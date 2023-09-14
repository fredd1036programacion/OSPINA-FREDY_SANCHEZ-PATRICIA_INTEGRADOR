package com.proyectoIntegrador.dentalClinic.controller;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.paciente.PacienteEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.paciente.PacienteSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;
import com.proyectoIntegrador.dentalClinic.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/pacientes")

public class PacienteController {

    private final IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // metodo tipo POST para paciente
    //debemos usar un post mapping
    //los endpoint que no necesitan "Registrar" o cualquier comentario, son los que listan ya que no es util para el usuario
    //@RequestBody es para que trabaje la informacion de java en Json

    // EL RESPONSE ENTITY para los Post LO QUE BUSCA ES Q CUANDO EJECUTA BIEN EL METODO, ME ARROJE UN 201 EN PSOTMAN LO CUAL ES QUE TODO QUEDO CORRECTO y el @Valid es para que valide la informacion que llega como parametros antes de proceder.
    @PostMapping("registrar")
    public ResponseEntity<PacienteSalidaDto> registrarPaciente(@Valid @RequestBody PacienteEntradaDto paciente) {
        return new ResponseEntity<>(pacienteService.registrarPaciente(paciente), HttpStatus.CREATED);
    }

    @PutMapping("actualizar")
    public ResponseEntity<PacienteSalidaDto> actualizarPaciente(@Valid @RequestBody PacienteModificacionEntradaDto paciente) throws ResourceNotFoundException {
        return new ResponseEntity<>(pacienteService.modificarPaciente(paciente), HttpStatus.OK);
    }


    //Ejercicio de la mesa clase de APIs. Clase 17


    @GetMapping(path = "consultaPaciente/{id}")
    public ResponseEntity<PacienteSalidaDto> consultarPaciente(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.buscarPacientePorId(id), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "eliminarPaciente/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return new ResponseEntity<>("Paciente Eliminado con exito", HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<PacienteSalidaDto>> listarPaciente() {
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.FOUND);
    }

    @GetMapping("hola")
    public String saludar() {
        String saludo = "prueba q funciona la api de fredy";
        return saludo;
    }
}

