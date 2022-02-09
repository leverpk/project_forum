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

    @GetMapping("/category/{id}/thread/add")
    public String threadAddForm(Model model, @PathVariable Long id){
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("categoryId", id);
        return "/thread/thread-add-form";
    }

    @PostMapping("/category/{id}/thread")
    public String threadAdd(@ModelAttribute ThreadDto threadDto, @PathVariable Long id){
        threadService.addThread(threadDto, id);
        return "redirect:/category/" + id + "/thread";
    }

    @GetMapping("/category/{id}/thread")
    public String threadList(Model model, @PathVariable Long id) {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("threads", threadService.findAllThreadsInSubcategory(id));
        model.addAttribute("categoryId", id);
        return "/thread/list";
    }
}
