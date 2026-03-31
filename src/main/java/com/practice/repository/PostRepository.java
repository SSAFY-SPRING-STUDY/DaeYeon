package com.practice.repository;

import com.practice.controller.dto.request.PostRequest;
import com.practice.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PostRepository{

    List<PostEntity> postList = new ArrayList<>();

    public PostEntity save(PostEntity entity){
        postList.add(entity);
        return entity;
    }

    public List<PostEntity> findAll(){
        return postList;
    }

    public Optional<PostEntity> findById(Long id) {
        for (PostEntity postEntity : postList) {
            if (postEntity.getId().equals(id)) {
                return Optional.of(postEntity);
            }
        }
        return Optional.empty();
    }

    public void update(Long id, PostRequest request) {
        Optional<PostEntity> optional = findById(id);
        PostEntity entity = null;
        if(optional.isPresent())
            entity = optional.get();

        entity.modify(request.getTitle(), request.getContent());
    }

    public void deleteById(Long id){
        Optional<PostEntity> optional = findById(id);
        if(optional.isPresent())
            postList.remove(optional.get());
    }
}
