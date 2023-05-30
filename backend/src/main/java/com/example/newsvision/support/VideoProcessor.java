package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class VideoProcessor {

    @Autowired
    private ArticleTextProcessor articleTextProcessor;

    public String videoProcess(ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");

        articleTextProcessor.articleTitleProcess(articleDTO);
        WebClient webClient = WebClient.builder().baseUrl("http://nginx").build();

        return webClient.post()
                .uri("/tts")
                .bodyValue(articleDTO)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
