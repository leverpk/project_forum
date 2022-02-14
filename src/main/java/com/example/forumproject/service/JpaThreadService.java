package com.example.forumproject.service;

import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.model.Category;
import com.example.forumproject.model.Thread;
import com.example.forumproject.repository.CategoryRepository;
import com.example.forumproject.repository.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class JpaThreadService implements ThreadService{

    private final ThreadRepository threadRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Thread addThread(ThreadDto newThread, Long categoryId) {
        Thread thread = Thread.builder()
                .title(newThread.getTitle())
                .description(newThread.getDescription())
                .build();
        Thread savedThread = threadRepository.save(thread);
        Category category = categoryRepository.getById(categoryId);
        category.getThreadList().add(savedThread);
        categoryRepository.save(category);
        return savedThread;
    }

    @Override
    public List<Thread> findAllThreads() {
        return threadRepository.findAll();
    }

    @Override
    public List<Thread> findAllThreadsInSubcategory(Long id) {
        return categoryRepository.findById(id).map(Category::getThreadList).orElseThrow();
    }

    @Override
    public Thread getById(Long id) {
        return threadRepository.getById(id);
    }
}
