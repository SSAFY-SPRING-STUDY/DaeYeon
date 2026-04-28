package com.practice.domain.post.controller.dto;

import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.post.entity.PostEntity;

public record PostRequest(
    String title,
    String content
){
    public static PostEntity toEntity(PostRequest request, MemberEntity memberEntity) {
        return PostEntity.create(request.title, request.content, memberEntity);
    }
}

