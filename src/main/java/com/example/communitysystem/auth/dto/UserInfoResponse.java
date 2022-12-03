package com.example.communitysystem.auth.dto;

import lombok.Builder;


public record UserInfoResponse(
        Long id,
        String username,
        String email) {
    @Builder public UserInfoResponse {}
}
