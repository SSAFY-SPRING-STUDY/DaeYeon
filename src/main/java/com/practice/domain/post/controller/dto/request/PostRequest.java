package com.practice.domain.post.controller.dto.request;

import com.practice.domain.post.entity.PostEntity;

public record PostRequest(String title, String content, String author) {
    public static PostEntity toEntity(PostRequest request) {
        return new PostEntity(request.title, request.content, request.author);
    }
}

