package com.example.communitysystem.shared;

import com.example.communitysystem.community.exception.CommunityNameNotUniqueException;
import com.example.communitysystem.auth.exception.UsernameNotUniqueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class NameNotUniqueHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CommunityNameNotUniqueException.class, UsernameNotUniqueException.class})
    public ResponseEntity<?> handleNameNotUniqueException(RuntimeException ex) {
        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getMessage())
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.badRequest().body(response);
    }
}
