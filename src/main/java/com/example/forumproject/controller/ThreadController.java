package com.example.forumproject.controller;

import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.service.CategoryService;
import com.example.forumproject.service.ThreadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadService threadService;
    private final CategoryService categoryService;

    @GetMapping("/add")
    public String threadAddForm(){
        return "/thread/thread-add-form";
    }

    @PostMapping("/add")
    public String threadAdd(@ModelAttribute ThreadDto threadDto, Model model){
        model.addAttribute("thread", threadService.addThread(threadDto));
        return "redirect:/thread/list";
    }

    @GetMapping("/category/{id}/thread")
    public String threadList(Model model, @PathVariable Long id) {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("threads", threadService.findAllThreadsInSubcategory(id));
        return "/thread/list";
    }
}
