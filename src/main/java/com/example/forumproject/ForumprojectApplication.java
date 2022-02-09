package com.example.forumproject;

import com.example.forumproject.model.Category;
import com.example.forumproject.model.Thread;
import com.example.forumproject.model.User;
import com.example.forumproject.repository.CategoryRepository;
import com.example.forumproject.repository.ThreadRepository;
import com.example.forumproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ForumprojectApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;

    public ForumprojectApplication(CategoryRepository categoryRepository, UserRepository userRepository, ThreadRepository threadRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.threadRepository = threadRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ForumprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category itWork = categoryRepository.save(Category.builder()
                .title("Praca w IT")
                .build());
        Category languages = categoryRepository.save(Category.builder()
                .title("Programowanie")
                .build());
        Category other = categoryRepository.save(Category.builder()
                .title("Nauka i inne")
                .build());
        Category afterWork = categoryRepository.save(Category.builder()
                .title("Work life balance")
                .build());
        categoryRepository.save(Category.builder()
                .title("Ogłoszenia dla Juniorów")
                .parentCategoryId(itWork.getId())
                .description("Ogłoszenia o pracę")
                .build());
        categoryRepository.save(Category.builder()
                .title("Java")
                .parentCategoryId(languages.getId())
                .description("języki i technologie")
                .build());
        categoryRepository.save(Category.builder()
                .title("Szkoły")
                .parentCategoryId(other.getId())
                .description("polecane szkoły programowania")
                .build());
        categoryRepository.save(Category.builder()
                .title("Relaks z grami")
                .parentCategoryId(afterWork.getId())
                .description("polecane gry")
                .build());
        Thread javaQuestions = threadRepository.save(Thread.builder()
                .title("Pytania z Javy")
                .build());
        categoryRepository.save(Category.builder()
                .title("Pytania rekrutacyjne")
                .parentCategoryId(itWork.getId())
                .description("Baza pytań rekrutacyjnych")
                .threadList(List.of(javaQuestions))
                .build());
        final User user1 = userRepository.save(User.builder()
                .email("admin@sda.pl")
                .username("admin")
                .password("1234")
                .role("ROLE_ADMIN")
                .enabled(true)
                .build());
        final User user2 = userRepository.save(User.builder()
                .email("user@sda.pl")
                .username("user")
                .password("1234")
                .role("ROLE_USER")
                .enabled(true)
                .build());
    }
}
