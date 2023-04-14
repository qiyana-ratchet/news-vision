package com.example.newsvision.model;

import com.example.newsvision.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name="k_content",length = 5000)
    private String k_content;

    @Column(name="p_content",length = 5000)
    private String p_content;

    @Column(name="video_uri")
    private URI videoPath;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
}
