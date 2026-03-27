package com.practice.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class PostRequest{
    private final String title;
    private final String content;
    private final String author;
}

