package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleCommand;
import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleDTOConverter {

    @Autowired
    ArticleProcessing articleProcessing;
    @Autowired
    VideoProcessing videoProcessing;

    public Article toEntity(ArticleDTO articleDTO){
        return Article.builder()
                .id(articleDTO.getId())
                .title(articleDTO.getTitle())
                .reporter(articleDTO.getReporter())
                .articleTime(articleDTO.getArticleTime())
                .article(articleDTO.getArticle())
                .processedArticle(articleDTO.getProcessedArticle())
                .videoPath(articleDTO.getVideoPath())
                .build();
    }

    public ArticleDTO toDTOFromEntity(Article article) throws Exception{
        return null;
    }

    public ArticleDTO toDTOFromCommand(ArticleCommand command) throws Exception{
        ArticleDTO articleDTO = new ArticleDTO();
        String processedArticle = articleProcessing.articleProcess(command.getArticle());
        //videoProcess

        articleDTO.setTitle(command.getTitle());
        articleDTO.setReporter(command.getReporter());
        articleDTO.setArticleTime(command.getArticleTime());
        articleDTO.setArticle(command.getArticle());
        articleDTO.setArticle(processedArticle);
        articleDTO.setVideoPath(null); //
        return articleDTO;
    }

}
