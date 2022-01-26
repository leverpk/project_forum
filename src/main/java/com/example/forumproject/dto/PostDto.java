package com.example.forumproject.dto;

import com.example.forumproject.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class PostDto {

    User user;
    String content;
    LocalDateTime created;
}
