package com.example.newsvision.service;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import com.example.newsvision.persistence.ArticleRepository;
import com.example.newsvision.support.ArticleDTOConverter;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class NewsVisionService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleDTOConverter articleDTOConverter;


    /**
     *
     * API 에서 받아온 String result를 넣고, jsonParser로 하나씩 파싱해서, 전부 데이터 저장.
     */
    public void saveArticles(List<ArticleDTO> articleDTOS) throws ParseException {
        if(articleDTOS == null) throw new IllegalArgumentException("no articleDTOs");
        List<Article> articles = new ArrayList<>();
        articles = articleDTOConverter.articleDTOsToEntities(articleDTOS);
        for(int i = 0; i < articles.size(); ++i){
            articleRepository.save(articles.get(i));
        }
    }

    public ArticleDTO findById(Integer id) throws Exception{
        if (id == null) throw new IllegalArgumentException("no id");
        Optional<Article> article = articleRepository.findById(id);
        ArticleDTO articleDTO = articleDTOConverter.articleEntityToDTO(article.get());
        return articleDTO;
    }

    public void updateVideoPath(ArticleDTO articleDTO) throws Exception{
        //구현
    }


//        public ArticleDTO createArticle(final ArticleDTO articleDTO) throws Exception {
//        if (articleDTO == null) throw new IllegalArgumentException("no articleDTO");
//        Article article = articleDTOConverter.toEntity(articleDTO);
//        return articleDTOConverter.toDTOFromEntity(articleRepository.save(article));
//    }

}








