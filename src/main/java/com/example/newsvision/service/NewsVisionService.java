package com.example.newsvision.service;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import com.example.newsvision.persistence.ArticleRepository;
import com.example.newsvision.support.ArticleDTOConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class NewsVisionService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleDTOConverter articleDTOConverter;

    public ArticleDTO createArticle(final ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");
        Article article = articleDTOConverter.toEntity(articleDTO);
        return articleDTOConverter.toDTOFromEntity(articleRepository.save(article));
    }

}
