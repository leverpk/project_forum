package com.example.forumproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Thread {

    @Id
    private Long id;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @OneToMany
    private List<Post> postList;
    private String title;
    private String description;
    private LocalDateTime date;

}
