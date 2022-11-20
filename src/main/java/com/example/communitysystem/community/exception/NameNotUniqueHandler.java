package com.example.communitysystem.community.exception;

import com.example.communitysystem.shared.ErrorResponse;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NameNotUniqueHandler {

    @ExceptionHandler(value = {NameNotUniqueException.class})
    public ResponseEntity<ErrorResponse> handleNameNotUniqueException(NameNotUniqueException ex) {
        ErrorResponse response = ErrorResponse.builder().build();
        throw new NotYetImplementedException();
        // TODO Build response with error details and return this from the method.
    }
}
