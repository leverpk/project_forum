package com.example.forumproject.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Category {

    @Id
    private Long id;
    @OneToMany
    private List<Thread> threadList;
    private String title;
    private String description;
}
