// ES LA FORMA DE LLAMAR NORMALMENTE LA CLASE QUE MANEJA DE MANERA GLOBAL LA EXCEPCIONTES. QUE TODA LA APLICACION MANEJE SU EXCEPCIONES A TRAVES DE ESTA CLASE

package com.proyectoIntegrador.dentalClinic.exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
