package com.practice.domain;

import com.practice.global.exception.error.ErrorCode;

public record ApiResponse<T>(
    String message,
    T data
){
  public static <T> ApiResponse<T> success(T data){
    return new ApiResponse<>("Success", data);
  }

  public static ApiResponse<Void> success(){
    return new ApiResponse<>("Success", null);
  }

  public static ApiResponse<Void> error(ErrorCode errorCode){
    return new ApiResponse<>(errorCode.getMessage(), null);
  }
}
