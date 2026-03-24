package com.practice.controller;

import com.practice.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    public final HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        String str = helloService.hi();
        return str;
    }
}
