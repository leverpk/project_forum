package com.example.forumproject.service;

import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.model.Thread;

import java.util.List;

public interface ThreadService {

    // Adding methods

    Thread addThread(ThreadDto newThread);
    List<Thread> findAllThreads();

}
