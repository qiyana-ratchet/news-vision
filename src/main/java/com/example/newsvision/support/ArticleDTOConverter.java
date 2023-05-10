package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        JSONObject totalObject = (JSONObject) parser.parse(apiStr);
        JSONArray articleArray = (JSONArray) totalObject.get("DATA");
        JSONObject articleObject;
        for(int i = 0; i < articleArray.size(); i++) {
            articleObject = (JSONObject) articleArray.get(i);
            String title = articleObject.get("TITLE").toString();
            String content = articleObject.get("BODY").toString();
            String reporter = articleObject.get("WRITER_NAME").toString();
            String temp_url = Policy.imgSource + articleObject.get("IMG").toString();
            String thum_url = temp_url.replace("T.jpg","P4.jpg");
            String temp_date = articleObject.get("DATETIME").toString();

            LocalDateTime broadcast_date = LocalDateTime.parse(temp_date,
                    DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));

            articleDTOs.add(ArticleDTO.builder()
                    .title(title)
                    .broadcast_date(broadcast_date)
                    .reporter(reporter)
                    .content(content)
                    .thumUrl(thum_url)
                    .build());
        }
        return articleDTOs;
    }

    public Article articleDTOToEntity(ArticleDTO articleDTO){
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");
        return Article.builder()
                .id(articleDTO.getId())
                .title(articleDTO.getTitle())
                .broadcast_date(articleDTO.getBroadcast_date())
                .reporter(articleDTO.getReporter())
                .content(articleDTO.getContent())
                .p_content(articleDTO.getP_content())
                .thumUrl(articleDTO.getThumUrl())
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
        return ArticleDTO.builder()
                .id(article.getId())
                .title(article.getTitle())
                .broadcast_date(article.getBroadcast_date())
                .reporter(article.getReporter())
                .content(article.getContent())
                .p_content(article.getP_content())
                .thumUrl(article.getThumUrl())
                .videoPath(article.getVideoPath())
                .genre(article.getGenre())
                .build();
    }

    public List<ArticleDTO> articleEntitiesToDTO(List<Article> articles) throws Exception {
        if(articles == null) throw new IllegalArgumentException("no articles");
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for(Article article : articles){
            articleDTOS.add(this.articleEntityToDTO(article));
        }
        return articleDTOS;
    }

    public Page<ArticleDTO> articleEntitiesToDTO(Page<Article> articlePage) throws Exception {
        if(articlePage == null) throw new IllegalArgumentException("no articlePage");
        Page<ArticleDTO> articleDTOPage = articlePage.map(m ->
                ArticleDTO.builder()
                        .id(m.getId())
                        .title(m.getTitle())
                        .broadcast_date(m.getBroadcast_date())
                        .reporter(m.getReporter())
                        .content(m.getContent())
                        .p_content(m.getP_content())
                        .thumUrl(m.getThumUrl())
                        .videoPath(m.getVideoPath())
                        .genre(m.getGenre())
                        .build());

        return articleDTOPage;
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
