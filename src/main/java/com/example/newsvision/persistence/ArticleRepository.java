package com.example.newsvision.persistence;

import com.example.newsvision.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select a from Article a")
    public Page<Article> selectAll(Pageable pageable);

    //<S extends T> S save(S entity);

}

/*
1. 기사 삽입 (o)
2. 기사 조회 (날짜로 조회, ID로 조회, 영상이 있는 기사 조회?)
3. 모든 기사 조회 (o)
4. 기사 삭제 (날짜 기준으로 삭제)
 */