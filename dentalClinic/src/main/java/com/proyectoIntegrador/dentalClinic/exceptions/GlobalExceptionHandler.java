package com.proyectoIntegrador.dentalClinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// para que gestiones las excepciones de forma global. con esto se dice la clase que controle las intrucciones de errres que esten indicadas
@RestControllerAdvice
public class GlobalExceptionHandler {
    //nos administra o maneja na exception
    @ExceptionHandler({ResourceNotFoundException.class})
    //lo que este abajo es la exception que va a manejar el metodo

    //el rsponseStatus no indica que el Httpstatus tiene que ser seteado a la Response entity advaiciado por este rest controles
    @ResponseStatus(HttpStatus.NOT_FOUND)

    //El map almacena en pares de clave - valor. para el ejemplo clave string valor string. almacena objetos, elementos etc

    public Map<String, String> ManejarResourceNotFound(ResourceNotFoundException resourceNotFoundException) {
        Map<String, String> exceptionMessage = new HashMap<>();
        //para agragar a una coleccion map se agrega no con add sino con put. el 1er string message es el mensaje de error es como decir message = fredy es malo.
        exceptionMessage.put("message", "Recurso no encontrado: " + resourceNotFoundException.getMessage());
        return exceptionMessage;
    }


    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> procesarBadRequest(BadRequestException exception) {
        Map<String, String> exceptionMessage = new HashMap<>();
        exceptionMessage.put("message", "Bad request: " + exception.getMessage());
        return exceptionMessage;
    }

}
