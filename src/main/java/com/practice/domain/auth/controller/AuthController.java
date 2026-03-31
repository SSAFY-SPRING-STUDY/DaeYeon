package com.practice.domain.auth.controller;

import com.practice.domain.auth.controller.dto.request.LoginRequest;
import com.practice.domain.auth.controller.dto.response.LoginResponse;
import com.practice.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    private String getAccessToken(String authHeader){
        return authHeader.split(" ")[1];
    }

    /**
     * "Authorization" : "Bearer {accessToken<UUID>}"
     * */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestHeader("Authorization") String authHeader,
            @RequestBody LoginRequest request){

        String accessToken = getAccessToken(authHeader);

        LoginResponse loginResponse = authService.login(request, accessToken);


        return null;
    }



}
