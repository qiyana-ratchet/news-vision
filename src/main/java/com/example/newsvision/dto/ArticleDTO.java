package com.example.newsvision.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.net.URI;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ArticleDTO {


    private String title;


    private String content;


    private String newsUrl;


    private String thumUrl;


    private LocalDateTime date;



}
