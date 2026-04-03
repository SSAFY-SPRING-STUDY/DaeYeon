package com.practice.domain.post.service;

import com.practice.domain.post.controller.dto.request.PostRequest;
import com.practice.domain.post.controller.dto.response.PostResponse;
import com.practice.domain.post.entity.PostEntity;
import com.practice.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse save(PostRequest request) {
        PostEntity postEntity = PostRequest.toEntity(request);
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
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("게시물 X"));
        return PostResponse.fromEntity(post);
    }

    public void update(Long id, PostRequest request) {
        postRepository.update(id, request);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
