package com.practice.domain.member.controller.dto;

import com.practice.domain.member.entity.MemberEntity;

public record MemberRequest(
        String loginId,
        String password,
        String name
){
    public MemberEntity toEntity(){
        return MemberEntity.create(loginId, password, name);
    }
}
