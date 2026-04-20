package com.practice.global.exception.handler;

import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import com.practice.global.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse response = new ErrorResponse(
                errorCode.getMessage()
        );
        return ResponseEntity.status(errorCode.getStatus()).body(response);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorResponse> handleMissingHeader(){
        return ResponseEntity
            .status(ErrorCode.INVALID_PARAMETER.getStatus())
            .body(ErrorResponse.of(ErrorCode.INVALID_PARAMETER.getMessage()));
    }
}
