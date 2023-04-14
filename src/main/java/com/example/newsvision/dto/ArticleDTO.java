package com.example.newsvision.dto;

import com.example.newsvision.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.net.URI;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {

    private Integer id;

    private String title;

    private String content;

    private String newsUrl;

    private String thumUrl;

    private LocalDateTime broadcast_date;

    private String k_content;

    private String p_content;

    private URI videoPath;

    private Genre genre;
}
