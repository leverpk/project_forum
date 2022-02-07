package com.example.forumproject;

import com.example.forumproject.model.Category;
import com.example.forumproject.model.User;
import com.example.forumproject.repository.CategoryRepository;
import com.example.forumproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumprojectApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public ForumprojectApplication(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ForumprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category itWork = categoryRepository.save(Category.builder()
                .title("Praca w IT")
                .build());
        categoryRepository.save(Category.builder()
                .title("Pytania rekrutacyjne").parentCategoryId(itWork.getId())
                .description("Baza pytań rekrutacyjnych")
                .build());
//        categoryRepository.save(Category.builder()
//                .title("Ogłoszenia dla Juniorów")
//                .description("Ogłoszenia o pracę")
//                .build());
//        categoryRepository.save(Category.builder()
//                .title("Java")
//                .description("Wszystko o Javie")
//                .build());
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
