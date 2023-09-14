package com.proyectoIntegrador.dentalClinic.controller;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.turno.TurnoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.turno.TurnoSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.BadRequestException;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;
import com.proyectoIntegrador.dentalClinic.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private ITurnoService turnoService;

    @Autowired

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    //POST
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@Valid @RequestBody TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        return new ResponseEntity<>(turnoService.registrarTurno(turnoEntradaDto), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@Valid @RequestBody TurnoModificacionEntradaDto turno) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.modificarTurno(turno), HttpStatus.OK);
    }

    @GetMapping(path = "consultaturno/{id}")
    public ResponseEntity<TurnoSalidaDto> consultarTurno(@PathVariable Long id) {
        return new ResponseEntity<>(turnoService.buscarTurnoPorId(id), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "eliminarTurno/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurno(id);
        return new ResponseEntity<>("Turno Eliminado con exito", HttpStatus.NO_CONTENT);
    }

    @GetMapping()
    public ResponseEntity<List<TurnoSalidaDto>> listarTurno() {
        return new ResponseEntity<>(turnoService.listarTurno(), HttpStatus.FOUND);
    }

    @GetMapping("holaTurno")
    public String saludar() {
        String saludo = "prueba q funciona la api de fredyTurno";
        return saludo;
    }

}
