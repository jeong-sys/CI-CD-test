package com.example.wooamo_test.service;

import com.example.wooamo_test.entity.User;
import com.example.wooamo_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
