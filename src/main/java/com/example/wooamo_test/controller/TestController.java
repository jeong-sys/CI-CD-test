package com.example.wooamo_test.controller;

import com.example.wooamo_test.entity.User;
import com.example.wooamo_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class TestController {
    private final UserService userService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("test3");
        System.out.println("########### + " + DATABASE_USERNAME);
        return ResponseEntity.ok("Hello World test !!!");
    }

    @Value("${DATABASE_USERNAME}")
    private String DATABASE_USERNAME;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByUserEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}