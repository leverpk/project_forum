package com.example.forumproject.controller;

import com.example.forumproject.model.Category;
import com.example.forumproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String categoryAddForm(Model model) {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        return "/category/category-add-form";
    }

    @GetMapping("/parents")
    public String getParentCategories(Model model) {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        return "/category/parents";
    }

    @GetMapping("/{id}")
    public String getSubcategories(Model model, @PathVariable Long id) {
        model.addAttribute("parentCategories", categoryService.findCategoryByParentId(null));
        model.addAttribute("childCategories", categoryService.findCategoryByParentId(id));
        return "/category/subcategories";
    }
}
