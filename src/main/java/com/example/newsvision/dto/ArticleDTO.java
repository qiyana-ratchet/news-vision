package com.example.newsvision.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.net.URI;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ArticleDTO {

    private Integer id;

    private String title;

    private String reporter;

    private LocalDateTime articleTime;

    private String article;

    private String processedArticle;

    private URI videoPath;
}
