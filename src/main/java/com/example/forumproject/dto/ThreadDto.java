package com.example.forumproject.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThreadDto {

    @NotNull
    String title;
    @NotNull
    String description;



}
