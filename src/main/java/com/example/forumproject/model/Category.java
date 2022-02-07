package com.example.forumproject.model;

import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private Long parentCategoryId;
    @OneToMany
    private List<Thread> threadList;
    private String title;
    private String description;

}
