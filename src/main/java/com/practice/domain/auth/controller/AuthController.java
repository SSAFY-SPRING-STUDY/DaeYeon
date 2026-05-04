package com.practice.domain.auth.controller;

import com.practice.domain.auth.controller.dto.LoginRequest;
import com.practice.domain.auth.controller.dto.LoginResponse;
import com.practice.domain.auth.service.AuthService;
import com.practice.domain.auth.util.AuthorizationUtils;
import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import com.practice.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
    private final AuthService authService;
    /**
     * "Authorization" : "Bearer {accessToken<UUID>}"
     *
     */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        return ApiResponse.success(authService.login(request));
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> logout(@RequestHeader("Authorization") String authHeader) {
        if(!AuthorizationUtils.isValidToken(authHeader)){
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
        String accessToken = AuthorizationUtils.getAccessToken(authHeader);
        authService.logout(accessToken);
        return ApiResponse.success();
    }
}
