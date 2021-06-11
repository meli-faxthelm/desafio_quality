package com.bootcamp.desafio_quality.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DistrictNotFoundException extends ResponseStatusException {
    private String rejectedValue;
    public DistrictNotFoundException(String rejectedValue) {
        super(HttpStatus.NOT_FOUND, "O bairro passado não está cadastrado");
        this.rejectedValue = rejectedValue;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }
}
