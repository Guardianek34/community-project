package com.example.communitysystem.shared;

import lombok.Builder;

import java.util.Date;

public record ErrorResponse(
        int statusCode,
        Date timestamp,
        String message,
        String description) {
    @Builder public ErrorResponse {}
}
