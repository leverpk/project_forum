package com.example.forumproject.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Vote {

    @Id
    private Long id;
    @ManyToOne(targetEntity = Post.class) // Many Vote for One Post
    private Post post;
    @ManyToOne(targetEntity = User.class)
    private User user;
    private Integer stars;
    private LocalDateTime creationDate;

}
