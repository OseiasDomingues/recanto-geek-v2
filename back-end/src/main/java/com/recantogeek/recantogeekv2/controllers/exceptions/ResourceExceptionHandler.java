package com.recantogeek.recantogeekv2.controllers.exceptions;

import com.recantogeek.recantogeekv2.services.exceptions.DatabaseException;
import com.recantogeek.recantogeekv2.services.exceptions.ObjNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjNotFoundException.class)
    ResponseEntity<StandardError> objNotFound(ObjNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String msgError = "Objeto não encontrado";
        StandardError err = new StandardError(Instant.now(),status.value(),msgError,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<StandardError> databaseError(DatabaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String msgError = "Error no banco de dados";
        StandardError err = new StandardError(Instant.now(),status.value(),msgError,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
