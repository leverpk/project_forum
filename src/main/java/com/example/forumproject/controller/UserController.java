package com.example.forumproject.controller;

import com.example.forumproject.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}
