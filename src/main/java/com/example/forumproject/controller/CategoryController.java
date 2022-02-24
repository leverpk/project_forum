package com.example.forumproject.controller;

import com.example.forumproject.dto.CategoryDto;
import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public String addCategory(@ModelAttribute CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return "redirect:/";
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
