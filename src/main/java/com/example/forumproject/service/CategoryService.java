package com.example.forumproject.service;

import com.example.forumproject.dto.CategoryDto;
import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.model.Category;
import com.example.forumproject.model.Thread;

import java.util.List;

public interface CategoryService {

    Category addCategory(CategoryDto newCategory);
    void removeCategoryById(Long id);
    void updateCategoryTitle(Long id, String title);
  //  List<Thread> findAllThreads();
}
