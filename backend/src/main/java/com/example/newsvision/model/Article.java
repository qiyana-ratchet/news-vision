package com.example.newsvision.model;

import com.example.newsvision.enums.Genre;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

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

    @Column(name="title", unique = true)
    private String title;

    @Column(name ="broadcast_date")
    private LocalDateTime broadcast_date;

    @Column(name="reporter")
    private String reporter;

    @Column(name="content",length = 5000)
    private String content;

    @Column(name="p_content",length = 5000)
    private String p_content;

    @Column(name="thum_url")
    private String thumUrl;

    @Column(name="video_uri")
    private URI videoPath;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public Article(Integer id, String title, LocalDateTime broadcast_date, String reporter, String thumUrl, Genre genre){
        this.id = id;
        this.title = title;
        this.broadcast_date = broadcast_date;
        this.reporter = reporter;
        this.thumUrl = thumUrl;
        this.genre = genre;
    }
}
