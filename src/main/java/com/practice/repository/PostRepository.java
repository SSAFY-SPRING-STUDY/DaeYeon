package com.practice.repository;

import com.practice.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    List<PostEntity> postList = new ArrayList<>();

    public PostEntity save(PostEntity postEntity){
        postList.add(postEntity);

        return postEntity;
    }

    public List<PostEntity> findAll(){
        return postList;
    }
}
