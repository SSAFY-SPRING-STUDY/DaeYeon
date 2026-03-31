package com.practice.domain.member.service;

import com.practice.domain.member.controller.dto.request.MemberRequest;
import com.practice.domain.member.controller.dto.response.MemberResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse createMember(MemberRequest request) {
        MemberEntity memberEntity = MemberEntity.fromRequest(request);
        MemberEntity savedEntity = memberRepository.saveMember(memberEntity);

        return MemberResponse.fromEntity(savedEntity);
    }

    public MemberResponse findById(String loginId) {
        MemberEntity memberEntity = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        return MemberResponse.fromEntity(memberEntity);
    }
}
