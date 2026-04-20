package com.practice.global.response;

public record ErrorResponse(
        String message
) {
  public static ErrorResponse of(String message){
    return new ErrorResponse(message);
  }
}
