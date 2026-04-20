package com.practice.domain.post.controller.dto.response;

import com.practice.domain.member.controller.dto.response.MemberResponse;
import com.practice.domain.post.entity.PostEntity;

public record PostResponse(
    Long id,
    String title,
    String content,
    MemberResponse memberInfo
) {
    public static PostResponse fromEntity(PostEntity post, MemberResponse memberResponse) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                memberResponse
        );
    }
}
