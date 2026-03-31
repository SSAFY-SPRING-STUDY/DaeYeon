package com.practice.domain.auth.service;

import com.practice.domain.auth.component.SessionManager;
import com.practice.domain.auth.controller.dto.request.LoginRequest;
import com.practice.domain.auth.controller.dto.response.LoginResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    public LoginResponse login(LoginRequest request, String accessToken){
        MemberEntity member = memberRepository.findByLoginId(request.loginId())
                .orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 올바르지 않습니다."));

        sessionManager.createSession(member.getId());

        return null;
    }
}
