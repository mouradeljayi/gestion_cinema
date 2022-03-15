package com.elj.gestioncinema.exceptions;

public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException() {
    }

    public EntityAlreadyExistException(String message) {
        super(message);
    }
}
