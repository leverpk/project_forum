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
        return "/category/category-add-form";
    }

    @GetMapping("/category/parents")
    public String getParentCategories(Model model){
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        return "/category/parents";
    }

    @GetMapping("/category/work")
    public String workList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "/category/work";
    }

    @GetMapping("/category/languages")
    public String languagesList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "/category/languages";
    }

    @GetMapping("/category/learning")
    public String learningList(){
        return "/category/learning";
    }
}
