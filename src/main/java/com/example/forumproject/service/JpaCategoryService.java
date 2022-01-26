package com.example.forumproject.service;

import com.example.forumproject.dto.CategoryDto;
import com.example.forumproject.model.Category;
import com.example.forumproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class JpaCategoryService implements CategoryService{


    private final CategoryRepository categoryRepository;

    public JpaCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(CategoryDto newCategory) {
        final Category category= Category.builder()
                .title(newCategory.getTitle())
                .description(newCategory.getDescription())
                .date(newCategory.getDate())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public void removeCategoryById(Long id) {

        categoryRepository.deleteById(id);

    }

    @Override
    public void updateCategoryTitle(Long id, String title) {



    }


}
