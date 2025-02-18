package com.example.wooamo_test.service;

import com.example.wooamo_test.entity.User;
import com.example.wooamo_test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        User user = new User(null, "홍길동", "hong@example.com");
        when(userRepository.save(user)).thenReturn(new User(1L, "홍길동", "hong@example.com"));

        User savedUser = userService.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("홍길동", savedUser.getName());
    }

    @Test
    void testFindUserByEmail() {
        User user = new User(1L, "홍길동", "hong@example.com");
        when(userRepository.findByEmail("hong@example.com")).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findByUserEmail("hong@example.com");

        assertTrue(foundUser.isPresent());
        assertEquals("홍길동", foundUser.get().getName());
    }
}
