package com.practice.domain.member.entity;

import com.practice.domain.member.controller.dto.request.MemberRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberEntity {
    private static Long AutoIncrement = 1L;

    private Long id;
    private String loginId;
    private String password;
    private String name;

    public static MemberEntity fromRequest(MemberRequest request){
        return new MemberEntity(AutoIncrement++, request.loginId(), request.password(), request.name());
    }
}
