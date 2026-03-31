package com.practice.domain.member.controller.dto.response;

import com.practice.domain.member.entity.MemberEntity;

public record MemberResponse(
        Long id,
        String loginId,
        String name
) {

    public static MemberResponse fromEntity(MemberEntity member) {
        return new MemberResponse(member.getId(),
                member.getLoginId(),
                member.getName());
    }
}
