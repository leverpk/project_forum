package com.example.forumproject.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class UserDto {

    String username;
    String email;
    LocalDateTime signUpDate;

}
