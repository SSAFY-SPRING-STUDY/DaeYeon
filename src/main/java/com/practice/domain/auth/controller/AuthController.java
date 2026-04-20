package com.practice.domain.auth.controller;

import com.practice.domain.ApiResponse;
import com.practice.domain.auth.controller.dto.request.LoginRequest;
import com.practice.domain.auth.controller.dto.response.LoginResponse;
import com.practice.domain.auth.service.AuthService;
import com.practice.domain.auth.util.AuthorizationUtils;
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
        String accessToken = AuthorizationUtils.getAccessToken(authHeader);
        authService.logout(accessToken);
        return ApiResponse.success();
    }
}
