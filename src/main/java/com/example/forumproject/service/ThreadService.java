package com.example.forumproject.service;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ThreadService {

    Thread addThread(Thread newThread);
    List<Thread> findAll();
    // TODO: dodawanie wątku (service czy controller?)
    // TODO: jakie metody do threadService

}
