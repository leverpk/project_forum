package com.example.forumproject.controller;

import com.example.forumproject.model.User;
import com.example.forumproject.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        registrationService.register(user);
        return "";
    }

    @GetMapping("/register")
    public String confirm(@RequestParam("token") String token) {
        registrationService.confirmToken(token);
        return "register-form";
    }

}
