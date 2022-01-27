package com.example.forumproject.controller;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.service.PostService;
import com.example.forumproject.service.ThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/post/add")
    public String postAdd(@ModelAttribute PostDto postDto, Model model){
        model.addAttribute("post", postService.addPost(postDto));
        return "redirect:/post/list";
    }

    @GetMapping("/post/list")
    public String postList(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return "/post/list";
    }

}
