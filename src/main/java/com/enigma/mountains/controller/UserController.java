package com.enigma.mountains.controller;

import com.enigma.mountains.entity.User;
import com.enigma.mountains.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
