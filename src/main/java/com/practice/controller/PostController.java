package com.practice.controller;

import com.practice.controller.dto.PostRequest;
import com.practice.controller.dto.PostResponse;
import com.practice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/posts")
    public PostResponse createPost(@RequestBody PostRequest request) {
        PostResponse response = postService.save(request);

        return response;
    }

    @GetMapping("/api/posts")
    public List<PostResponse> findAllPosts() {
        return postService.findAll();
    }
}

