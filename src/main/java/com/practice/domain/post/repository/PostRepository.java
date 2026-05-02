package com.practice.domain.post.repository;

import com.practice.domain.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public interface PostRepository extends JpaRepository<PostEntity, Long> {

    public PostEntity save(PostEntity entity);

    public List<PostEntity> findAll();

    public Optional<PostEntity> findById(Long id);

    public void delete(PostEntity post);
}
