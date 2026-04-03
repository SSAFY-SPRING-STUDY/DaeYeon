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
        MemberEntity memberEntity = MemberRequest.toEntity(request);
        MemberEntity savedEntity = memberRepository.saveMember(memberEntity);

        return MemberResponse.fromEntity(savedEntity);
    }

    public MemberResponse findById(Long id) throws Exception{
        MemberEntity entity = memberRepository.findById(id).orElseThrow(
                () -> new RuntimeException("사용자 정보를 불러올 수 없습니다.")
        );
        return MemberResponse.fromEntity(entity);
    }

}
