package com.practice.domain.member.service;

import com.practice.domain.member.controller.dto.request.MemberRequest;
import com.practice.domain.member.controller.dto.response.MemberResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse createMember(MemberRequest request) {
        MemberEntity memberEntity = MemberRequest.toEntity(request);
        MemberEntity savedEntity = memberRepository.saveMember(memberEntity);

        return MemberResponse.fromEntity(savedEntity);
    }

    public MemberResponse findById(Long id){
        MemberEntity entity = memberRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)
        );
        return MemberResponse.fromEntity(entity);
    }

}
