package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Post {

    @Id
    private Long id;
    private Long threadId;
    private Long userId;
    private String content;
    private LocalDateTime created;

}
