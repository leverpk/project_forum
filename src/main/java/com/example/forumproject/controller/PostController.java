package com.example.forumproject.controller;

import com.example.forumproject.dto.PostDto;
import com.example.forumproject.service.CategoryService;
import com.example.forumproject.service.PostService;
import com.example.forumproject.service.ThreadService;
import com.example.forumproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@RequiredArgsConstructor
@Controller

public class PostController {

    private final PostService postService;
    private final CategoryService categoryService;
    private final ThreadService threadService;
    private final UserService  userService;


    @GetMapping("/category/{id}/thread/{idThread}/post/add")
    public String postAddForm(Model model, @PathVariable Long id, @PathVariable Long idThread)  {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("threadId", idThread);
        model.addAttribute("categoryId", id);
        model.addAttribute("thread",threadService.getById(idThread));
        return "/post/post-add-form";
    }

    @PostMapping("/category/{id}/thread/{idThread}/post")
    public String postAdd(@ModelAttribute PostDto postDto, Model model, @PathVariable Long id, @PathVariable Long idThread,Principal principal) {
        postService.addPost(postDto, id, idThread, principal);
        model.addAttribute("threadId", idThread);
        return "redirect:/category/" + id + "/thread/" + idThread + "/post";
    }

    @GetMapping("/category/{id}/thread/{idThread}/post")
    public String postsList(Model model, @PathVariable Long id, @PathVariable Long idThread) {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("threads", threadService.findAllThreadsInSubcategory(id));
        model.addAttribute("categoryId", id);
        model.addAttribute("posts", postService.findAllPostsInThread(idThread));
        model.addAttribute("threadId", idThread);
        model.addAttribute("threadTitle", threadService.getById(idThread));
        return "/post/list";
    }


}
