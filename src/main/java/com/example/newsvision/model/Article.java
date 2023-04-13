package com.example.newsvision.model;

import com.example.newsvision.dto.ArticleDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.net.URI;
import java.time.LocalDateTime;

@Entity
@Table(name="Article")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Article {

    public Article(String title, String content, String newsUrl, String thumUrl,LocalDateTime broadcast_date){
        this.title = title;
        this.content = content;
        this.newsUrl = newsUrl;
        this.thumUrl = thumUrl;
        this.broadcast_date = broadcast_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="content",length = 5000)
    private String content;

    @Column(name="news_url")
    private String newsUrl;

    @Column(name="thum_url")
    private String thumUrl;

    @Column(name ="broadcast_date")
    private LocalDateTime broadcast_date;

    //번역된 기사를 여기다 넣으려고함. 지금은 Content에 들어가 있는 것은 영문;
    @Column(name="k_content")
    private String p_article;

    @Column(name="uri")
    private URI videoPath;


//
//    @Column(name="p_article")
//    @Lob
//    private String processedArticle;
//
//    @Column(name="uri")
//    private URI videoPath;

}
