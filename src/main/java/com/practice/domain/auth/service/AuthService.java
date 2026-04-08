package com.practice.domain.auth.service;

import com.practice.domain.auth.component.SessionManager;
import com.practice.domain.auth.controller.dto.request.LoginRequest;
import com.practice.domain.auth.controller.dto.response.LoginResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    public LoginResponse login(LoginRequest request){
        MemberEntity member = memberRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new CustomException(ErrorCode.LOGINID_NOT_FOUND));

        // 나중에는 passwordEncoder 사용해서 (rawPassword, encodedPassword)형태로.
        // 지금은 학습 수준이니까 용인
        if(member.isValidPassword(request.password())){
            String token = sessionManager.createSession(member.getId());
            return new LoginResponse(token, "Bearer");
        }
        throw new CustomException(ErrorCode.LOGINPASSWORD_NOT_MATCHED);
    }

    public void logout(String accessToken) {
        sessionManager.removeSession(accessToken);
    }

    public Long getMemberId(String token){
        return sessionManager.getMemberId(token).orElseThrow(() -> new CustomException(ErrorCode.MEMBER_NOT_FOUND));
    }
}
