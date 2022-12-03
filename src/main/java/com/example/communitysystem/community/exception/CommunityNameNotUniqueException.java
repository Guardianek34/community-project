package com.example.communitysystem.community.exception;

public class CommunityNameNotUniqueException extends RuntimeException {
    public CommunityNameNotUniqueException() {
        super("Provided community's name is not unique.");
    }
}
