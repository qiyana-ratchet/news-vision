package com.example.newsvision.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleCommand {

    @NotEmpty(message="Title is required")
    private String title;

    @NotEmpty(message="Reporter is required")
    private String reporter;

    @Past
    @NotEmpty(message="articleTime is required")
    private LocalDateTime articleTime;

    @NotEmpty(message="Article is required")
    private String article;

}
