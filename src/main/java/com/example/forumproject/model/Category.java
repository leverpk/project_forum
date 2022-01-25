package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Category {

    @Id
    private Long id;
    @OneToMany
    private List<Thread> threadList;
    private String title;
    private String description;
    private LocalDateTime date;

}
