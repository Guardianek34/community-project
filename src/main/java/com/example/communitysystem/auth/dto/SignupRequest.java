package com.example.communitysystem.auth.dto;

public record SignupRequest(
        String username,
        String email,
        String password) {
}
