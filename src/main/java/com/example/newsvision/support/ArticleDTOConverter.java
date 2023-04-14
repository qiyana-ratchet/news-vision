package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleDTOConverter {

    @Autowired
    ArticleTextProcessor articleTextProcessor;
    @Autowired
    VideoProcessor videoProcessor;


    public List<ArticleDTO> articleApiStrToDTOs(String apiStr) throws ParseException {
        List<ArticleDTO> articleDTOs = new ArrayList<>();

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(apiStr);
        JSONArray items = (JSONArray) object.get("items");
        for(int i=0; i<items.size(); i++) {
            object = (JSONObject) items.get(i);
            String title = (String) object.get("title");
            String content = (String) object.get("content");
            String news_url = (String) object.get("news_url");
            String thum_url = (String) object.get("thum_url");
            String temp_date = (String) object.get("broadcast_date");

            // Casting이 바로 안되서, DATETIME casting 과정을 거침.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime broadcast_date = LocalDateTime.parse(temp_date, formatter);

            articleDTOs.add(new ArticleDTO(null, title, content, news_url, thum_url, broadcast_date,
                    null, null, null, null));
        }
        return articleDTOs;
    }

    public Article articleDTOToEntity(ArticleDTO articleDTO){
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");
        return Article.builder()
                .id(articleDTO.getId())
                .title(articleDTO.getTitle())
                .content(articleDTO.getContent())
                .newsUrl(articleDTO.getNewsUrl())
                .thumUrl(articleDTO.getThumUrl())
                .broadcast_date(articleDTO.getBroadcast_date())
                .k_content(articleDTO.getK_content())
                .p_content(articleDTO.getP_content())
                .videoPath(articleDTO.getVideoPath())
                .genre(articleDTO.getGenre())
                .build();
    }

    public List<Article> articleDTOsToEntities(List<ArticleDTO> articleDTOS){
        if(articleDTOS == null) throw new IllegalArgumentException("no articleDTOs");
        List<Article> articles = new ArrayList<>();
        for(int i = 0; i < articleDTOS.size(); ++i){
            articles.add(this.articleDTOToEntity(articleDTOS.get(i)));
        }
        return articles;
    }

    public ArticleDTO articleEntityToDTO(Article article) throws Exception{
        if(article == null) throw new IllegalArgumentException("no article");
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(article.getId());
        articleDTO.setTitle(article.getTitle());
        articleDTO.setContent(article.getContent());
        articleDTO.setNewsUrl(article.getNewsUrl());
        articleDTO.setThumUrl(article.getThumUrl());
        articleDTO.setBroadcast_date(article.getBroadcast_date());
        articleDTO.setK_content(article.getK_content());
        articleDTO.setP_content(article.getP_content());
        articleDTO.setVideoPath(article.getVideoPath());
        articleDTO.setGenre(article.getGenre());
        return articleDTO;
    }


//    public ArticleDTO toDTOFromCommand(ArticleCommand command) throws Exception{
//        if(command == null) throw new IllegalArgumentException("no command");
//        ArticleDTO articleDTO = new ArticleDTO();
//        String processedArticle = articleProcessing.articleProcess(command.getArticle());
//        //videoProcess
//
//        articleDTO.setTitle(command.getTitle());
//        articleDTO.setReporter(command.getReporter());
//        articleDTO.setArticleTime(command.getArticleTime());
//        articleDTO.setArticle(command.getArticle());
//        articleDTO.setArticle(processedArticle);
//        articleDTO.setVideoPath(null); //
//        return articleDTO;
//    }

}
