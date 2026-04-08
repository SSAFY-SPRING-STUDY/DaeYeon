package com.practice.domain.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationUtils {
    public static String getAccessToken(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7); // "Bearer " 이후 토큰만 추출
        }
        throw new IllegalArgumentException("Invalid Authorization header");
    }
}
