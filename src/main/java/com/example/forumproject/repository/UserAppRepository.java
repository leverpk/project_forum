package com.example.forumproject.repository;

import com.example.forumproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
