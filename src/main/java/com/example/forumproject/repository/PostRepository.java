package com.example.forumproject.repository;

import com.example.forumproject.model.Post;
import com.example.forumproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUser_Id(Long id);


}
