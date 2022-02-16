package com.example.forumproject.service;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.model.Post;
import com.example.forumproject.model.Thread;
import com.example.forumproject.repository.CategoryRepository;
import com.example.forumproject.repository.PostRepository;
import com.example.forumproject.repository.ThreadRepository;
import com.example.forumproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaPostService implements PostService {

    private final PostRepository postRepository;
    private final ThreadRepository threadRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public Post addPost(PostDto newPost, Long id, Long threadId, Principal principal) {
        Post post = Post.builder()
                .content(newPost.getContent())
                .created(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                .user(userRepository.findByUsername(principal.getName()))
                .build();
        Post savedPost = postRepository.save(post);
        Thread thread = threadRepository.getById(threadId);
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

    @Override
    public List<Post> findAllPostsByUser(Long id) {
        return postRepository.findPostsByUser_Id(id);
    }

}
