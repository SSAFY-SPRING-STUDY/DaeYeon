package com.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    public String hi(){
        return "Hello Spring";
    }
}
