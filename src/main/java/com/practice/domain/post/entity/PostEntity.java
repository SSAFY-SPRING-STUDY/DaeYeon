package com.practice.domain.post.entity;

import com.practice.domain.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity author;

    public static PostEntity create(String title, String content, MemberEntity author) {
        return new PostEntity(null, title , content, author);
    }

    public void modify(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
