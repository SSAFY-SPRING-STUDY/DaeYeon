package com.practice.domain.post.entity;

import com.practice.domain.member.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostEntity {
    private static Long AUTO_INCREMENT = 1L;

    private final Long id;
    private String title;
    private String content;
    private final MemberEntity author;

    private PostEntity(String title, String content, MemberEntity author) {
        this.id = AUTO_INCREMENT++;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public static PostEntity create(String title, String content, MemberEntity author) {
        return new PostEntity(title, content, author);
    }

    public void modify(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
