package com.example.forumproject.service;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.model.Post;

import java.security.Principal;
import java.util.List;

public interface PostService {

    Post addPost(PostDto newPost, Long id, Long threadId, Principal principal);
    List<Post> findAllPosts();
    List<Post> findAllPostsInThread(Long id);
    List<Post> findAllPostsByUser(Long id);
    List<Post> findAllPostsByWord(String word);

}
