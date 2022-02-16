package com.example.forumproject.controller;

import com.example.forumproject.service.CategoryService;
import com.example.forumproject.service.PostService;
import com.example.forumproject.service.ThreadService;
import com.example.forumproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final ThreadService threadService;
    private final CategoryService categoryService;

    @GetMapping("/{idUser}/posts")
    public String userPostsList(Model model, @PathVariable Long idUser){
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("posts", postService.findAllPostsByUser(idUser));
        model.addAttribute("username", userService.findById(idUser));
        return "/post/posts-by-user";
    }

}
