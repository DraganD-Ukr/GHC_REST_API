package com.dragand.ghc_api.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entityClass) {
        super("The " + entityClass.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in our records");
    }
}