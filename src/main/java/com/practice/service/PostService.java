package com.practice.service;

import com.practice.controller.dto.request.PostRequest;
import com.practice.controller.dto.response.PostResponse;
import com.practice.domain.member.entity.MemberEntity;
import com.practice.domain.member.repository.MemberRepository;
import com.practice.entity.PostEntity;
import com.practice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostResponse save(PostRequest request, long authorId){
        MemberEntity author = memberRepository.findById(authorId).orElseThrow(
                () -> new IllegalArgumentException("Member not found")
        );

        PostEntity postEntity = new PostEntity(request.getTitle(),
                request.getContent(),
                author);

        PostEntity savedEntity = postRepository.save(postEntity);

        PostResponse response = PostResponse.fromEntity(savedEntity);

        return response;
    }

    public List<PostResponse> findAll(){
        List<PostEntity> postList = postRepository.findAll();
        List<PostResponse> list = new ArrayList<>();
        for(PostEntity postEntity : postList){
            PostResponse response = PostResponse.fromEntity(postEntity);
            list.add(response);
        }
        return list;
    }

    public PostResponse findById(Long id){
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("게시물 X"));
        return PostResponse.fromEntity(post);
    }

    public void update(Long id, PostRequest request) {
        postRepository.update(id, request);
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }
}
