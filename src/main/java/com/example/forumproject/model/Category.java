package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Category {

    @Id
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;

}
