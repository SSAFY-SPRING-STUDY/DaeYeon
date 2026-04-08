package com.practice.domain.post.repository;

import com.practice.domain.post.entity.PostEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class PostRepository {

    List<PostEntity> postList = new ArrayList<>();

    public PostEntity save(PostEntity entity) {
        postList.add(entity);
        return entity;
    }

    public List<PostEntity> findAll() {
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

    public void delete(PostEntity post) {
        postList.remove(post);
    }
}
