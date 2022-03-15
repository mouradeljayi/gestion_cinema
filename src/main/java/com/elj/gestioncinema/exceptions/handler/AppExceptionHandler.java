package com.elj.gestioncinema.exceptions.handler;

import com.elj.gestioncinema.exceptions.EntityAlreadyExistException;
import com.elj.gestioncinema.exceptions.EntityNotFoundException;
import com.elj.gestioncinema.shared.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundException(EntityNotFoundException e) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .code(404)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistException.class})
    public ResponseEntity<Object> entityAlreadyExistException(EntityAlreadyExistException e) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .code(409)
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
    }
}
