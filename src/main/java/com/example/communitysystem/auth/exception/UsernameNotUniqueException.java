package com.example.communitysystem.auth.exception;

public class UsernameNotUniqueException extends RuntimeException {
    public UsernameNotUniqueException() { super("Provided username is not unique."); }
}
