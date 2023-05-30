package com.example.newsvision.dto;

import com.example.newsvision.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.net.URI;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDTO {

    private Integer id;

    private String title;

    private String p_title;

    private LocalDateTime broadcast_date;

    private String reporter;

    private String content;

    private String p_content;

    private String thumUrl;

    private String videoPath;

    private Genre genre;
}
