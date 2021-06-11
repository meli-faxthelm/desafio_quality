package com.bootcamp.desafio_quality.exception;

import com.bootcamp.desafio_quality.dto.FieldValidationErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<FieldValidationErrorMessageDTO>> handleValidationException(MethodArgumentNotValidException exception) {
        List<FieldValidationErrorMessageDTO> errors = new ArrayList<>();
        for(FieldError ex : exception.getBindingResult().getFieldErrors()) {
            errors.add(new FieldValidationErrorMessageDTO(ex.getField(),ex.getRejectedValue().toString(),ex.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    protected ResponseEntity<FieldValidationErrorMessageDTO> handleDistrictNotFoundException(DistrictNotFoundException exception) {
        return ResponseEntity.status(exception.getStatus()).body(new FieldValidationErrorMessageDTO("prop_district",
                exception.getRejectedValue(), exception.getReason()));
    }
}
