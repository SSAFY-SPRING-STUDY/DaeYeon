package com.practice.domain.post.controller;

import com.practice.domain.auth.component.SessionManager;
import com.practice.domain.auth.util.AuthorizationUtils;
import com.practice.domain.post.controller.dto.PostRequest;
import com.practice.domain.post.controller.dto.PostResponse;
import com.practice.domain.post.service.PostService;
import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import com.practice.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final SessionManager sessionManager;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<PostResponse> createPost(@RequestBody PostRequest request, @RequestHeader("Authorization")String accessToken) {
        if(!AuthorizationUtils.isValidToken(accessToken)){
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
        String token = AuthorizationUtils.getAccessToken(accessToken);
        Long memberId = sessionManager.getMemberId(token);

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
    public ApiResponse<PostResponse> updatePost(@PathVariable Long id, @RequestBody PostRequest request, @RequestHeader("Authorization")String accessToken) {
        if(!AuthorizationUtils.isValidToken(accessToken)){
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
        String Token = AuthorizationUtils.getAccessToken(accessToken);
        Long authorId = sessionManager.getMemberId(Token);
        PostResponse response = postService.update(request, id, authorId);
        return ApiResponse.success(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApiResponse<Void> deletePost(@PathVariable Long id, @RequestHeader("Authorization")String accessToken) {
        if(!AuthorizationUtils.isValidToken(accessToken)){
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
        String token = AuthorizationUtils.getAccessToken(accessToken);
        Long authorId = sessionManager.getMemberId(token);
        postService.deleteById(id, authorId);

        return ApiResponse.success();
    }
}
