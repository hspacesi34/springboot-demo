package com.cda.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class entity) {
        super(entity.getSimpleName() + " not found");
    }
}
