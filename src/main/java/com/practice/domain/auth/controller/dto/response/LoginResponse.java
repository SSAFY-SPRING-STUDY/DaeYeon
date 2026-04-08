package com.practice.domain.auth.controller.dto.response;

public record LoginResponse(
        String accessToken,
        String tokenType
) {
}
