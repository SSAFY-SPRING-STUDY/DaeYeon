package com.practice.domain.post.service;

import com.practice.domain.member.controller.dto.response.MemberResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import com.practice.domain.member.service.MemberService;
import com.practice.domain.post.controller.dto.request.PostRequest;
import com.practice.domain.post.controller.dto.response.PostResponse;
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
    private final MemberService memberService;

    public PostResponse save(PostRequest request, Long authorId) {
        PostEntity postEntity = PostRequest.toEntity(request, authorId);
        PostEntity savedEntity = postRepository.save(postEntity);
        MemberResponse memberResponse = memberService.findById(authorId);
        return PostResponse.fromEntity(savedEntity, memberResponse);
    }

    public List<PostResponse> findAll() {
        List<PostEntity> postList = postRepository.findAll();
        List<PostResponse> list = new ArrayList<>();
        for (PostEntity postEntity : postList) {
            MemberResponse memberResponse = memberService.findById(postEntity.getAuthorId());
            PostResponse response = PostResponse.fromEntity(postEntity, memberResponse);
            list.add(response);
        }
        return list;
    }

    public PostResponse findById(Long id) {
        PostEntity post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );
        MemberResponse memberResponse = memberService.findById(post.getAuthorId());
        return PostResponse.fromEntity(post, memberResponse);
    }

    public void update(Long id, PostRequest request) {
        PostEntity post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );
        post.modify(request.title(), request.content());
    }

    public void deleteById(Long id) {
        PostEntity post = postRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.POST_NOT_FOUND)
        );
        postRepository.delete(post);
    }
}
