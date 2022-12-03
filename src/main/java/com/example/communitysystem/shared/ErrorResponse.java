package com.example.communitysystem.shared;

import lombok.Builder;

import java.time.Instant;

public record ErrorResponse(
        Instant timestamp,
        String message) {
    @Builder public ErrorResponse {}
}
