package com.example.newsvision.persistence;

import com.example.newsvision.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query(value = "select a from Article a", countQuery = "select(a) from Article a")
    Page<Article> selectAllbyPage(Pageable pageable);

    @Query(value = "select new com.example.newsvision.model.Article(a.id, a.title, " +
            "a.broadcast_date, a.reporter, a.thumUrl, a.genre) from Article a",
            countQuery = "select count(a) from Article a")
    Page<Article> selectThumbyPage(Pageable pageable);


}