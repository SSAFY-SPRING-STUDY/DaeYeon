package com.practice.service;

import com.practice.controller.dto.request.PostRequest;
import com.practice.controller.dto.response.PostResponse;
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

    public PostResponse save(PostRequest request){
        PostEntity postEntity = new PostEntity(request.getTitle(),
                request.getContent(),
                request.getAuthor());

        PostEntity returnedEntity = postRepository.save(postEntity);

        PostResponse response = new PostResponse(returnedEntity.getId(),
                returnedEntity.getTitle(),
                returnedEntity.getTitle(),
                returnedEntity.getAuthor());

        return response;
    }

    public List<PostResponse> findAll(){
        List<PostEntity> postList = postRepository.findAll();
        List<PostResponse> list = new ArrayList<>();
        for(PostEntity postEntity : postList){
            PostResponse response = new PostResponse(postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getTitle(),
                    postEntity.getAuthor());
            list.add(response);
        }
        return list;
    }

    public PostResponse findById(Long id){
        PostEntity post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("게시물 X"));
        return new PostResponse(post);
    }

    public void update(Long id, PostRequest request) {
        postRepository.update(id, request);
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }
}
