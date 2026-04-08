package com.practice.domain.post.controller.dto.response;

import com.practice.domain.post.entity.PostEntity;

public record PostResponse(Long id, String title, String content, String author) {
    public static PostResponse fromEntity(PostEntity post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor()
        );
    }
}
