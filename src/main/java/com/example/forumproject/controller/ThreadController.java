package com.example.forumproject.controller;

import com.example.forumproject.service.ThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThreadController {

    private final ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }

    @GetMapping("/thread/add")
    public String threadAddForm(){
        return "/thread/thread-add-form";
    }
    // TODO: zrobić mappingi
}
