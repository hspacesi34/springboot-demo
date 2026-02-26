package com.cda.demo.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Map<String, String> response = new HashMap<>();

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFound(ResourceNotFoundException ex) {
        String status = Integer.toString(HttpStatus.NOT_FOUND.value());
        this.response.put("status", status);
        this.response.put("message", ex.getMessage());
        return this.response;
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleAlreadyExists(ResourceAlreadyExistsException ex) {
        String status = Integer.toString(HttpStatus.CONFLICT.value());
        this.response.put("status", status);
        this.response.put("message", ex.getMessage());
        return this.response;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleConstraintViolation(ConstraintViolationException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> messages = new HashMap<>();

        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String attributName = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            ArrayList<String> attribut = (ArrayList<String>) messages.getOrDefault(attributName, new ArrayList<String>());
            attribut.add(message);

            messages.put(attributName, attribut);
        }

        response.put("violations", messages);
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleMethodArgumentException(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> messages = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((violation) -> {

            String attributName = violation.getField();
            String message = violation.getDefaultMessage();

            ArrayList<String> attribut = (ArrayList<String>) messages.getOrDefault(attributName, new ArrayList<String>());
            attribut.add(message);

            messages.put(attributName, attribut);
        });
        response.put("violations", messages);
        return response;
    }
}
