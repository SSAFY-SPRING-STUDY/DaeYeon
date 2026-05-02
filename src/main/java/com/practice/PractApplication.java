package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class PractApplication {

    public static void main(String[] args) {
        SpringApplication.run(PractApplication.class, args);
    }

}
