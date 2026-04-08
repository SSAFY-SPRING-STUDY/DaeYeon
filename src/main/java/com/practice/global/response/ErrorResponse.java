package com.practice.global.response;

public record ErrorResponse(
        String code,
        String message
) {}
