package com.practice.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "잘못된 요청 파라미터입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 서비스입니다."),
    INVALID_PERMISSION(HttpStatus.FORBIDDEN, "해당 권한이 없습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다."),

    LOGINID_NOT_FOUND(HttpStatus.UNAUTHORIZED, "아이디가 올바르지 않습니다."),
    LOGINPASSWORD_NOT_MATCHED(HttpStatus.UNAUTHORIZED, "비밀번호가 올바르지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시물을 불러올 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
