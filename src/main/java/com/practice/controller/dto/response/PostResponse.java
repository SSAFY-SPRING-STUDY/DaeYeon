package com.practice.controller.dto.response;

import com.practice.entity.PostEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public static PostResponse fromEntity(PostEntity post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor()
        );
    }
}
