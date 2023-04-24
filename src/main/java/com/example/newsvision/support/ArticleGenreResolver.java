package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.enums.Genre;
import com.example.newsvision.support.chatgpt.ChatGpt;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleGenreResolver {

    public ArticleDTO resolveGenre(ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");

        //구현
        String content = articleDTO.getContent();
        ChatGpt chatgpt = new ChatGpt("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");
        String genr1 =chatgpt.ask(content + " 여기까지가 기사야. 이것을 읽고, POLITICS,\n" +
                "    WORLD,\n" +
                "    ECONOMY,\n" +
                "    FOREIGN_POLICY,\n" +
                "    NORTH_KOREA,\n" +
                "    COVID_19,\n" +
                "   s LIFE_CULTURE,\n" +
                "    IT_SCIENCE,\n" +
                "    SPORTS,\n" +
                "    WEATHER  중 어느 것에 속하는 기사인지 위에 기준대로 한단어로 출력해.");
        Genre genre = Genre.valueOf(genr1.toUpperCase());
        articleDTO.setGenre(genre);

        return articleDTO;

    }

    public List<ArticleDTO> resolveGenre(List<ArticleDTO> articleDTOS) throws Exception{
        if(articleDTOS == null) throw new IllegalArgumentException("no articleDTOS");

        for(ArticleDTO articleDTO: articleDTOS) {
            String content = articleDTO.getContent();
            ChatGpt chatgpt = new ChatGpt("chatgpt key 등록");
            String genrTemp = chatgpt.ask(content + " 여기까지가 기사야. 분류기준은 (POLITICS,\n" +
                    "    WORLD,\n" +
                    "    ECONOMY,\n" +
                    "    FOREIGN_POLICY,\n" +
                    "    NORTH_KOREA,\n" +
                    "    COVID_19,\n" +
                    "    LIFE_CULTURE,\n" +
                    "    IT_SCIENCE,\n" +
                    "    SPORTS,\n" +
                    "    WEATHER )" + " 인데, 기사를 읽고, 분류기준중에 하나를 골라 출력해. 조건은 분류기준중에 하나를 고르는 것이고, 절대로 이것을 벗어나면 안돼.");


            Genre genre = Genre.valueOf(genrTemp.toUpperCase());
            articleDTO.setGenre(genre);
        }
        //구현
        return articleDTOS;
    }
}
