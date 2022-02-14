package com.example.forumproject.dto;

import com.example.forumproject.model.User;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class PostDto {

    User user;
    @NotNull
    String content;
    String created;
}
