package com.example.forumproject.service;

import com.example.forumproject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class JpaUserService implements UserService{

    private final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
