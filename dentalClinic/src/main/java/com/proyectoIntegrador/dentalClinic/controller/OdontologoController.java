package com.proyectoIntegrador.dentalClinic.controller;


import com.proyectoIntegrador.dentalClinic.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.entrada.odontologo.OdontologoEntradaDto;
import com.proyectoIntegrador.dentalClinic.dto.salida.odontologo.OdontologoSalidaDto;
import com.proyectoIntegrador.dentalClinic.exceptions.ResourceNotFoundException;
import com.proyectoIntegrador.dentalClinic.service.IOdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
// salia un error en la api que no dejaba desde js ejecutar en fetch de local host. se corrige con el @Crossorigin.
@CrossOrigin
@RequestMapping("/odontologos")
public class OdontologoController {

    private final IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    // metodo tipo POST para paciente
    //debemos usar un post mapping
    //los endpoint que no necesitan "Registrar" o cualquier comentario, son los que listan ya que no es util para el usuario
    //@RequestBody es para que trabaje la informacion de java en Json

    @PostMapping("registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(odontologoService.guardarOdontologo(odontologo), HttpStatus.CREATED);
    }

    @PutMapping("actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody OdontologoModificacionEntradaDto odontologoModificado) throws ResourceNotFoundException  {
        return new ResponseEntity<>(odontologoService.modificarOdontologo(odontologoModificado), HttpStatus.OK);
    }


    //Ejercicio de la mesa clase de APIs. Clase 17


    @GetMapping(path = "/consultaOdontologo/{id}")
    public ResponseEntity<OdontologoSalidaDto> consultarOdontologo(@PathVariable Long id) {
        return new ResponseEntity<>(odontologoService.buscarOdontologoPorId(id), HttpStatus.FOUND);
    }

    @DeleteMapping(path = "/eliminarOdontologo/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo modificado correctamente", HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/consultarTodo")
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologo() {
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.FOUND);
    }

    @GetMapping("holaOdontologo")
    public String saludar() {
        String saludo = "prueba q funciona la api de fredy Odontologo";
        return saludo;
    }


}
