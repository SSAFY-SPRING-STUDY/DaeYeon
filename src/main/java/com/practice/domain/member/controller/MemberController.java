package com.practice.domain.member.controller;

import com.practice.domain.auth.service.AuthService;
import com.practice.domain.auth.util.AuthorizationUtils;
import com.practice.domain.member.controller.dto.MemberRequest;
import com.practice.domain.member.controller.dto.MemberResponse;
import com.practice.domain.member.service.MemberService;
import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import com.practice.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<MemberResponse> createMember(@RequestBody MemberRequest request){
        MemberResponse response = memberService.createMember(request);
        return ApiResponse.success(response);
    }

    @GetMapping("/me")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<MemberResponse> getMyInfo(@RequestHeader("Authorization") String authHeader){
        if(!AuthorizationUtils.isValidToken(authHeader)){
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
        String token = AuthorizationUtils.getAccessToken(authHeader);
        Long memberId = authService.getMemberId(token);
        return ApiResponse.success(memberService.findById(memberId));
    }
}
