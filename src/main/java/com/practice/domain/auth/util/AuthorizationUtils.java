package com.practice.domain.auth.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthorizationUtils {
    private static final String BEARER_PREFIX = "Bearer ";

    public static boolean isValidToken(String authHeader){
        return authHeader != null && authHeader.startsWith(BEARER_PREFIX);
    }
    public static String getAccessToken(String authHeader) {
        return authHeader.substring(BEARER_PREFIX.length()); // "Bearer " 이후 토큰만 추출
    }
}
