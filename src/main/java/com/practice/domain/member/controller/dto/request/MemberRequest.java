package com.practice.domain.member.controller.dto.request;

public record MemberRequest(
        String loginId,
        String password,
        String name
){

}
