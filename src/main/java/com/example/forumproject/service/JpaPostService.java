package com.example.forumproject.service;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.model.Category;
import com.example.forumproject.model.Post;
import com.example.forumproject.model.Thread;
import com.example.forumproject.repository.CategoryRepository;
import com.example.forumproject.repository.PostRepository;
import com.example.forumproject.repository.ThreadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaPostService implements PostService {

    private final PostRepository postRepository;
    private final ThreadRepository threadRepository;
    private final CategoryRepository categoryRepository;

    public JpaPostService(PostRepository postRepository, ThreadRepository threadRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.threadRepository = threadRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Post addPost(PostDto newPost, Long id, Long threadId) {
        Post post = Post.builder()
                .content(newPost.getContent())
                .build();
        Post savedPost = postRepository.save(post);
        Thread thread = threadRepository.getById(threadId);
        Category category = categoryRepository.getById(id);
        thread.getPostList().add(savedPost);
        postRepository.save(post);
        return savedPost;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAllPostsInThread(Long id) {
        return threadRepository.findById(id).map(Thread::getPostList).orElseThrow();
    }
}
