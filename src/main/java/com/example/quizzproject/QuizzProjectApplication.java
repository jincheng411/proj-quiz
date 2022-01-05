package com.example.quizzproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.example.spring_filter.filter")
public class QuizzProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuizzProjectApplication.class, args);
    }
}
