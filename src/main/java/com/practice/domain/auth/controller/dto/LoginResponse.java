package com.practice.domain.auth.controller.dto;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
