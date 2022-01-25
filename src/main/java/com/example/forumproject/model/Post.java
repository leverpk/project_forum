package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Post {

    @Id
    private Long id;
    @ManyToOne(targetEntity = User.class)
    private User user;
    private String content;
    private LocalDateTime created;

}
