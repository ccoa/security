package com.occoa.security.controller;

import com.occoa.security.exception.EntityNotFoundException;
import com.occoa.security.exception.FieldValidationException;
import com.occoa.security.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<Object> handleFieldValidationException(FieldValidationException e) {
        log.error("", e);

        return Response.respond400(e.getMessage(), e.getErrors());
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        log.error("", e);

        return Response.respond500(e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("validation exception ", e);

        List<String> errors = new ArrayList<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : e.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        return Response.respond400(e.getMessage(), errors);
    }

    @ResponseBody
    public ResponseEntity<Object> handleSuccess(Object o) {

        return Response.ok();
    }
}
