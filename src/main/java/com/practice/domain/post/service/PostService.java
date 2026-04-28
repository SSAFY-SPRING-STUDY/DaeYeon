package com.practice.domain.post.service;

import com.practice.domain.member.controller.dto.MemberResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import com.practice.domain.member.service.MemberService;
import com.practice.domain.post.controller.dto.PostRequest;
import com.practice.domain.post.controller.dto.PostResponse;
import com.practice.domain.post.entity.PostEntity;
import com.practice.domain.post.repository.PostRepository;
import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostResponse save(PostRequest request, Long authorId) {
        MemberEntity author = memberRepository.findById(authorId).orElseThrow(
                () -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)
        );
        PostEntity postEntity = PostRequest.toEntity(request, author);
        PostEntity savedEntity = postRepository.save(postEntity);
        return PostResponse.fromEntity(savedEntity);
    }

    public List<PostResponse> findAll() {
        List<PostEntity> postList = postRepository.findAll();
        List<PostResponse> list = new ArrayList<>();
        for (PostEntity postEntity : postList) {
            PostResponse response = PostResponse.fromEntity(postEntity);
            list.add(response);
        }
        return list;
    }

    public PostResponse findById(Long id) {
        PostEntity post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );
        return PostResponse.fromEntity(post);
    }

    public PostResponse update(PostRequest request, Long id, Long authorId) {
        PostEntity post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );
        if(!post.getAuthor().getId().equals(authorId)){
            throw new CustomException(ErrorCode.INVALID_PERMISSION);
        }
        post.modify(request.title(), request.content());
        return PostResponse.fromEntity(post);
    }

    public void deleteById(Long id, Long authorId) {
        PostEntity post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );
        if(!post.getAuthor().getId().equals(authorId)){
            throw new CustomException(ErrorCode.INVALID_PERMISSION);
        }
        postRepository.delete(post);
    }
}
