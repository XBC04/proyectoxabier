package com.example.proyectoxabier.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ComprarAccessException extends ResponseStatusException {

    public ComprarAccessException(String reason) {
        super(HttpStatus.FORBIDDEN, reason);
    }
}