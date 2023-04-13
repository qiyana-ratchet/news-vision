package com.example.newsvision.service;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import com.example.newsvision.persistence.ArticleRepository;
import com.example.newsvision.support.ArticleDTOConverter;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional
@Slf4j
public class NewsVisionService {


    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleDTOConverter articleDTOConverter;


    /**
     * API를 활용해서, JSON으로 받아온다.
     *
     */
    public String getApiArticle() {
        String result = "";
        try {
            URL url = new URL("https://apis.data.go.kr/B551024/openArirangNewsApi/news?serviceKey=HEci6vuXdvuixZTrl%2BCC005MdpP7SRLGBfejMx7xlqgCvBcuq7hvpsn19J3Hla5cBoz6BxozJxjl2un4kRqsZg%3D%3D&pageNo=1&numOfRows=10");
            //뒤에 row는 기사 몇개 가져올 것인지, pageNo = pageNO;
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * API 에서 받아온 String result를 넣고, jsonParser로 하나씩 파싱해서, 전부 데이터 저장.
     */
    public void saveArticle(String result) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object =(JSONObject) parser.parse(result);
        JSONArray items = (JSONArray) object.get("items");
        for(int i=0; i<items.size(); i++){
            object = (JSONObject) items.get(i);
            String title = (String)object.get("title");
            String content =(String)object.get("content");
            String news_url =(String) object.get("news_url");
            String thum_url = (String) object.get("thum_url");
            String temp_date= (String) object.get("broadcast_date");

            // Casting이 바로 안되서, DATETIME casting 과정을 거침.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime broadcast_date = LocalDateTime.parse(temp_date,formatter);

            Article article = new Article(title,content,news_url,thum_url,broadcast_date);

            articleRepository.save(article);

        }
    }


    //    public ArticleDTO createArticle(final ArticleDTO articleDTO) throws Exception {
//        if (articleDTO == null) throw new IllegalArgumentException("no articleDTO");
//        Article article = articleDTOConverter.toEntity(articleDTO);
//        return articleDTOConverter.toDTOFromEntity(articleRepository.save(article));
//    }
}








