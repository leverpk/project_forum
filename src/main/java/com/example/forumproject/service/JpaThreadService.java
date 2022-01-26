package com.example.forumproject.service;

import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.model.Thread;
import com.example.forumproject.repository.ThreadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaThreadService implements ThreadService{

    private final ThreadRepository threadRepository;

    public JpaThreadService(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    @Override
    public Thread addThread(ThreadDto newThread) {
        Thread thread = Thread.builder()
                .title(newThread.getTitle())
                .description(newThread.getDescription())
                .build();
        return threadRepository.save(thread);
    }

    @Override
    public List<Thread> findAllThreads() {
        return threadRepository.findAll();
    }
}
