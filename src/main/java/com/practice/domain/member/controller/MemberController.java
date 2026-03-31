package com.practice.domain.member.controller;

import com.practice.domain.member.controller.dto.request.MemberRequest;
import com.practice.domain.member.controller.dto.response.MemberResponse;
import com.practice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponse> createMember(@RequestBody MemberRequest request){
        MemberResponse response = memberService.createMember(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponse> getMyInfo(@RequestHeader("Authorization") String authHeader){
        return null;
    }
}
