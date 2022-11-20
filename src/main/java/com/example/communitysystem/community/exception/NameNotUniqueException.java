package com.example.communitysystem.community.exception;

public class NameNotUniqueException extends RuntimeException {
    public NameNotUniqueException() {
        super("Provided community's name is not unique.");
    }
}
