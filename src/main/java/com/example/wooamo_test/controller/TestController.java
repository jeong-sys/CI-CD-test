package com.example.wooamo_test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("test2");
        return ResponseEntity.ok("Hello World test !!!!!");
    }
}