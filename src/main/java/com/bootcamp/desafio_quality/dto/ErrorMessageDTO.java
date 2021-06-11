package com.bootcamp.desafio_quality.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessageDTO {

    private String field;

    @JsonProperty("rejected_value")
    private String rejectedValue;

    @JsonProperty("error_message")
    private String errorMessage;

    public ErrorMessageDTO(String field, String rejectedValue, String errorMessage) {
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(String rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

