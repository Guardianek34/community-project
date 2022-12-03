package com.example.communitysystem.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;

@ControllerAdvice
public class EntityNotFoundExceptionHandler {
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
