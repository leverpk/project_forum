package com.example.forumproject;

import com.example.forumproject.model.*;
import com.example.forumproject.model.Thread;
import com.example.forumproject.repository.CategoryRepository;
import com.example.forumproject.repository.PostRepository;
import com.example.forumproject.repository.ThreadRepository;
import com.example.forumproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ForumprojectApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;
    private final PostRepository postRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ForumprojectApplication(CategoryRepository categoryRepository, UserRepository userRepository, ThreadRepository threadRepository, PostRepository postRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.threadRepository = threadRepository;
        this.postRepository = postRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
        final User user1 = userRepository.save(User.builder()
                .email("admin@sda.pl")
                .username("admin")
                .password(bCryptPasswordEncoder.encode("1234"))
                .role(UserRole.ADMIN)
                .enabled(true)
                .build());
        final User user2 = userRepository.save(User.builder()
                .email("user@sda.pl")
                .username("user")
                .password(bCryptPasswordEncoder.encode("1234"))
                .role(UserRole.USER)
                .enabled(true)
                .build());
//        Post postSopot = postRepository.save(Post.builder()
//                .content("Praca w Sopocie")
//                .created(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
//                .user(user1)
//                .build());
//        Post postGdansk = postRepository.save(Post.builder()
//                .content("asdafasfas")
//                .created(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
//                .user(user2)
//                .build());
        Thread javaOffers = threadRepository.save(Thread.builder()
                .title("Junior Java Developers")
                .build());
        Thread csharpOffers = threadRepository.save(Thread.builder()
                .title("Junior C# Developers")
                .build());
        Thread cPlusOffers = threadRepository.save(Thread.builder()
                .title("Junior C++ Developers")
                .build());
        Thread pythonOffers = threadRepository.save(Thread.builder()
                .title("Junior Python Developers")
                .build());
        categoryRepository.save(Category.builder()
                .title("Ogłoszenia dla Juniorów")
                .parentCategoryId(itWork.getId())
                .description("Ogłoszenia o pracę")
                .threadList(List.of(javaOffers, csharpOffers, cPlusOffers, pythonOffers))
                .build());
        Thread javaQuestions = threadRepository.save(Thread.builder()
                .title("Pytania rekrutacyjne z Javy")
                .build());
        Thread csharpQuestions = threadRepository.save(Thread.builder()
                .title("Pytania rekrutacyjne z C#")
                .build());
        Thread cPlusQuestions = threadRepository.save(Thread.builder()
                .title("Pytania rekrutacyjne z C++")
                .build());
        Thread pythonQuestions = threadRepository.save(Thread.builder()
                .title("Pytania rekrutacyjne z Pythona")
                .build());
        categoryRepository.save(Category.builder()
                .title("Pytania rekrutacyjne")
                .parentCategoryId(itWork.getId())
                .description("Baza pytań rekrutacyjnych")
                .threadList(List.of(javaQuestions, csharpQuestions, cPlusQuestions, pythonQuestions))
                .build());
        categoryRepository.save(Category.builder()
                .title("Java")
                .parentCategoryId(languages.getId())
                .description("języki i technologie")
                .build());
        categoryRepository.save(Category.builder()
                .title("C#")
                .parentCategoryId(languages.getId())
                .description("języki i technologie")
                .build());
        categoryRepository.save(Category.builder()
                .title("C++")
                .parentCategoryId(languages.getId())
                .description("języki i technologie")
                .build());
        categoryRepository.save(Category.builder()
                .title("Python")
                .parentCategoryId(languages.getId())
                .description("języki i technologie")
                .build());
        categoryRepository.save(Category.builder()
                .title("Szkoły programowania")
                .parentCategoryId(other.getId())
                .description("polecane szkoły programowania")
                .build());
        categoryRepository.save(Category.builder()
                .title("Relaks z grami")
                .parentCategoryId(afterWork.getId())
                .description("polecane gry")
                .build());
    }
}
