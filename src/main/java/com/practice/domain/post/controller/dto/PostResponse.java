package com.practice.domain.post.controller.dto;

import com.practice.domain.member.controller.dto.MemberResponse;
import com.practice.domain.post.entity.PostEntity;

public record PostResponse(
    Long id,
    String title,
    String content,
    MemberResponse memberResponse
) {
    public static PostResponse fromEntity(PostEntity post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                MemberResponse.fromEntity(post.getAuthor())
        );
    }
}
