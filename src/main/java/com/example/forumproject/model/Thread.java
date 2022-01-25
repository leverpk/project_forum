package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Thread {

    @Id
    private Long id;
    private Long categoryId;
    private Long userId;
    private String title;
    private String description;
    private LocalDateTime date;

}
