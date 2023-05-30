package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.enums.Genre;
import com.example.newsvision.support.chatgpt.ChatGpt;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ArticleGenreResolver {

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build();

    ChatGpt chatgpt = new ChatGpt("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", client);
    String text = "This is the text article given to you. Now think for yourself and categorize which of the seven genres I present (politics, economy, society, science, culture, sports, miscellent) you belong to. There are restrictions. It should be classified into one of the seven genres presented above, and the output should be outputted in one word with the classified genre and do not add anything.";

    public ArticleDTO resolveGenre(ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");

        String content = articleDTO.getContent();
        String genreTemp =chatgpt.ask(content+text);
        try {
            Genre genre = Genre.valueOf(genreTemp.toUpperCase());
            articleDTO.setGenre(genre);
        }catch(Exception e){
            articleDTO.setGenre(Genre.MISCELLANEOUS);
        }
        return articleDTO;

    }

    public List<ArticleDTO> resolveGenre(List<ArticleDTO> articleDTOS) throws Exception{
        if(articleDTOS == null) throw new IllegalArgumentException("no articleDTOS");

        for(ArticleDTO articleDTO: articleDTOS) {
            String content = articleDTO.getContent();
            String genreTemp =chatgpt.ask(content+text);
            try {
                Genre genre = Genre.valueOf(genreTemp.toUpperCase());
                articleDTO.setGenre(genre);
            }catch(Exception e){
                articleDTO.setGenre(Genre.MISCELLANEOUS);
            }
        }
        return articleDTOS;
    }
}
