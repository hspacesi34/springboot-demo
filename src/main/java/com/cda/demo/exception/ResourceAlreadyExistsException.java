package com.cda.demo.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(Class entity) {
        super(entity.getSimpleName() + " already exists");
    }
}
