package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Vote {

    @Id
    private Long id;
    private Long postId;
    private Long userId;
    private Integer stars;
    private LocalDateTime creationDate;

}
