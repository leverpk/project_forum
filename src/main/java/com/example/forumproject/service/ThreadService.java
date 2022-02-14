package com.example.forumproject.service;

import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.model.Thread;

import java.util.List;

public interface ThreadService {

    Thread addThread(ThreadDto newThread, Long id);
    List<Thread> findAllThreads();
    List<Thread> findAllThreadsInSubcategory(Long id);
    Thread getById(Long id);


}
