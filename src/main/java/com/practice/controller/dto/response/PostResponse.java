package com.practice.controller.dto.response;

import com.practice.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class PostResponse{
    private final Long id;
    private final String title;
    private final String content;
    private final String author;

    public PostResponse(PostEntity post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
