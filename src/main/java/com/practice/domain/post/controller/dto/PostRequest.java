package com.practice.domain.post.controller.dto;

import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.post.entity.PostEntity;

public record PostRequest(
    String title,
    String content
){
    public PostEntity toEntity(MemberEntity memberEntity) {
        return PostEntity.create(title, content, memberEntity);
    }
}

