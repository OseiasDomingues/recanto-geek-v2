package com.recantogeek.recantogeekv2.services.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("O produto de " + id + " não foi encontrado!");

    }
}
