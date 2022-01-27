package com.example.forumproject.controller;

import com.example.forumproject.dto.ThreadDto;
import com.example.forumproject.service.ThreadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/thread/add")
    public String threadAdd(@ModelAttribute ThreadDto threadDto, Model model){
        model.addAttribute("thread", threadService.addThread(threadDto));
        return "/thread/list";
    }

    @GetMapping("/thread/list")
    public String threadList(Model model) {
        model.addAttribute("threads", threadService.findAllThreads());
        return "/thread/list";
    }
}
