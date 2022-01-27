package com.example.forumproject.controller;

import com.example.forumproject.service.PostService;
import com.example.forumproject.service.ThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/add")
    public String postAddForm(){
        return "/post/post-add-form";
    }

}
