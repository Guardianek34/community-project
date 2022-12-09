package com.example.communitysystem.auth.dto;

import lombok.Builder;

import java.util.List;


public record UserInfoResponse(
        Long id,
        String username,
        String email,
        List<String> roles) {
    @Builder public UserInfoResponse {}
}
