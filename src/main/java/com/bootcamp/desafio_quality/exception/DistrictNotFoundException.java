package com.bootcamp.desafio_quality.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DistrictNotFoundException extends ResponseStatusException {
    public DistrictNotFoundException() {
        super(HttpStatus.NOT_FOUND, "O bairro passado não está cadastrado");
    }
}
