package com.example.forumproject.service;

import com.example.forumproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserService implements UserService, UserDetailsService {
private final UserRepository users;
    private final UserRepository userRepository;

    public JpaUserService(UserRepository users, UserRepository userRepository) {
        this.users = users;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.findByEmail(username).orElse(null);
    }
}
