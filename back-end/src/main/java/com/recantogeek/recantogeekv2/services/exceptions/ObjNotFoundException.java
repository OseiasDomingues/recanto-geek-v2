package com.recantogeek.recantogeekv2.services.exceptions;

import org.springframework.http.HttpStatus;

public class ObjNotFoundException extends RuntimeException {

    public ObjNotFoundException(Long id) {
        super("O produto de " + id + " não foi encontrado!");

    }
}
