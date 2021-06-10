package com.bootcamp.desafio_quality.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) {
        StringBuilder sb = new StringBuilder();
        for(FieldError ex : exception.getBindingResult().getFieldErrors()) {
            sb.append(ex.getDefaultMessage() + "\n");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    protected ResponseEntity<String> handleDistrictNotFoundException(DistrictNotFoundException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getReason());
    }
}
