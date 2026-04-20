package com.practice.domain.post.controller.dto.request;

import com.practice.domain.post.entity.PostEntity;

public record PostRequest(
    String title,
    String content
){
    public static PostEntity toEntity(PostRequest request, Long authorId) {
        return new PostEntity(request.title, request.content, authorId);
    }
}

