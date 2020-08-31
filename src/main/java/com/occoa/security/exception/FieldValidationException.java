package com.occoa.security.exception;

import lombok.Data;

import java.util.List;

@Data
public class FieldValidationException extends RuntimeException {

    private List<String> errors;

    public FieldValidationException(String message) {
        super(message);
    }

    public FieldValidationException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
