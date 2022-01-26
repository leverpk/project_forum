package com.example.forumproject.repository;

import com.example.forumproject.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


}
