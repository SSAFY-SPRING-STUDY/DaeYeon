package com.practice.service;

import com.practice.controller.dto.PostRequest;
import com.practice.controller.dto.PostResponse;
import com.practice.entity.PostEntity;
import com.practice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse save(PostRequest request) {
        PostEntity entity = new PostEntity(request.getTitle(), request.getContent(), request.getAuthor());
        PostEntity returnedEntity = postRepository.save(entity);

        PostResponse response = new PostResponse(returnedEntity.getId(),
                returnedEntity.getTitle(),
                returnedEntity.getContent(),
                returnedEntity.getAuthor());

        return response;
    }

    public List<PostResponse> findAll(){
        List<PostEntity> entityList = postRepository.findAll();
        List<PostResponse> responseList = new ArrayList<>();

        for(PostEntity entity : entityList){
            PostResponse response = new PostResponse(entity.getId(),
                    entity.getTitle(),
                    entity.getContent(),
                    entity.getAuthor());
            responseList.add(response);
        }
        return responseList;
    }
}
