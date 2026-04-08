package com.practice.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER-001", "서버 내부 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    LOGINID_NOT_FOUND(HttpStatus.UNAUTHORIZED, "AUTH_001", "아이디가 올바르지 않습니다."),
    LOGINPASSWORD_NOT_MATCHED(HttpStatus.UNAUTHORIZED, "AUTH_002", "비밀번호가 올바르지 않습니다."),
    MEMBER_NOT_FOUND(HttpStatus.UNAUTHORIZED, "AUTH_003", "정보를 조회할 수 없습니다."),

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST-001", "게시물을 불러올 수 없습니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;
}
