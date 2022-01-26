package com.example.forumproject.controller;

import com.example.forumproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/add")
    public String categoryAddForm(){
        return "/category/thread-add-form";
    }

    @GetMapping("/category/list")
    public String categoryList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "/category/list";
    }
    // TODO: zrobić mappingi
}
