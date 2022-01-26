package com.example.forumproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThreadDto {

    String title;
    String description;



}
