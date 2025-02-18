package com.example.wooamo_test.controller;

import com.example.wooamo_test.controller.TestController;
import com.example.wooamo_test.entity.User;
import com.example.wooamo_test.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private TestController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        User user = new User(null, "홍길동", "hong@example.com");
        when(userService.save(user)).thenReturn(new User(1L, "홍길동", "hong@example.com"));

        ResponseEntity<User> response = userController.saveUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("홍길동", response.getBody().getName());
    }

    @Test
    void testGetUserByEmail() {
        User user = new User(1L, 홍길동, "hong@example.com");
        when(userService.findByUserEmail("hong@example.com")).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getUserByEmail("hong@example.com");

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("홍길동", response.getBody().getName());
    }
}
