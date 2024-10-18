package com.example.bank_system.config;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex){
        String error = ex.getMessage();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<Object> handleRuntimeException(RuntimeException ex){
        String error = ex.getMessage();

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex) {
        String message = String.format("Invalid value for role: %s. Allowed values are: CUSTOMER, ADMIN", ex.getValue());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
