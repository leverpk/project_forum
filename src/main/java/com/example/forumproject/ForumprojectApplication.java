package com.example.forumproject;

import com.example.forumproject.model.Category;
import com.example.forumproject.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumprojectApplication implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public ForumprojectApplication(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ForumprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categoryRepository.save(Category.builder()
                .title("Kocham Springa")
                .description("Wszystko o Springu")
                .build());

        categoryRepository.save(Category.builder()
                .title("Kocham Javę")
                .description("Wszystko o Javie")
                .build());
    }
}
