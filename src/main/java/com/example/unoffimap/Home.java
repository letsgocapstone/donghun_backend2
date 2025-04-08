package com.example.unoffimap;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//홈화면 (http://localhost:8080/


@RestController
@RequestMapping("/")  // 루트 경로에 매핑
public class Home {
    @GetMapping
    public String home() {
        return "Hello, Spring Boot!";
    }
}
