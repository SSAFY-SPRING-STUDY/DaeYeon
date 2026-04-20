package com.practice.domain.post.controller;

import com.practice.domain.ApiResponse;
import com.practice.domain.auth.service.AuthService;
import com.practice.domain.auth.util.AuthorizationUtils;
import com.practice.domain.post.controller.dto.request.PostRequest;
import com.practice.domain.post.controller.dto.response.PostResponse;
import com.practice.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final AuthService authService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PostResponse> createPost(@RequestBody PostRequest request, @RequestHeader("Authorization")String accessToken) {
        String token = AuthorizationUtils.getAccessToken(accessToken);
        Long memberId = authService.getMemberId(token);

        return ApiResponse.success(postService.save(request, memberId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<PostResponse>> findAllPosts() {
        return ApiResponse.success(postService.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<PostResponse> findPostById(@PathVariable Long id) {
        return ApiResponse.success(postService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<Void> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        postService.update(id, request);
        return ApiResponse.success();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deletePost(@PathVariable Long id) {
        postService.deleteById(id);
        return ApiResponse.success();
    }
}
