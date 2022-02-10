package com.example.forumproject.service;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.model.Post;
import com.example.forumproject.model.Thread;

import java.util.List;

public interface PostService {

    Post addPost(PostDto newPost, Long id,Long threadId);
    List<Post> findAllPosts();
    List<Post> findAllPostsInThread(Long id);

}
