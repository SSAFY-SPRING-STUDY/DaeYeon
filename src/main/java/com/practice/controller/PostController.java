package com.practice.controller;

import com.practice.controller.dto.request.PostRequest;
import com.practice.controller.dto.response.PostResponse;
import com.practice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest request){
        PostResponse response = postService.save(request);
        return response;
    }

    @GetMapping
    public List<PostResponse> findAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostResponse findPostById(@PathVariable Long id){
        PostResponse response = null;
        try {
            response = postService.findById(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequest request){
        postService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deleteById(id);
    }
}
