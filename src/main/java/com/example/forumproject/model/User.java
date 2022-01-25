package com.example.forumproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class User {

    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime signUpDate;
    private String roles;


}
