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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="reporter", length=48)
    private String reporter;

    @Column(name="a_time")
    private LocalDateTime articleTime;

    @Column(name="article")
    @Lob
    private String article;

    @Column(name="p_article")
    @Lob
    private String processedArticle;

    @Column(name="uri")
    private URI videoPath;

}
