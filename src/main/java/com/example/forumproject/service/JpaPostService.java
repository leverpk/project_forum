package com.example.forumproject.service;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.model.Post;
import com.example.forumproject.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaPostService implements PostService{

    private final PostRepository postRepository;

    public JpaPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post addPost(PostDto postDto) {
        return null;
    }

    @Override
    public List<Post> findAllPosts() {
        return null;
    }
}
