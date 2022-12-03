package com.example.communitysystem.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User has not been found in database.");
    }
}
