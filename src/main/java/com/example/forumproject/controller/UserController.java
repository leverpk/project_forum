package com.example.forumproject.controller;

import com.example.forumproject.service.CategoryService;
import com.example.forumproject.service.PostService;
import com.example.forumproject.service.ThreadService;
import com.example.forumproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final ThreadService threadService;
    private final CategoryService categoryService;

    @GetMapping("/posts")
    public String userPostsList(Model model){
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));

        return "/post/posts-by-user";
    }

}
