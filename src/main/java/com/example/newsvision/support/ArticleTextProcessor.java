package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleTextProcessor {

    public String articleProcess(String origin) throws Exception{
        if(origin == null) throw new IllegalArgumentException("no origin");

        String result;
        result = origin.replaceAll("\\(.*\\)", "")
                .replaceAll("\\[.*\\]", "")
                .replaceAll("\\{.*\\}", "")
                .replaceAll("%", "퍼센트")
                .replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9,.!? ]", "");

        return result;
    }

    public ArticleDTO articleProcess(ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");

        String p_string = articleProcess(articleDTO.getContent());
        articleDTO.setP_content(p_string);

        return articleDTO;
    }

    public List<ArticleDTO> articleProcess(List<ArticleDTO> articleDTOS) throws Exception{
        if(articleDTOS == null) throw new IllegalArgumentException("no articleDTOS");

        for(int i = 0; i < articleDTOS.size(); ++i){
            articleDTOS.set(i, articleProcess(articleDTOS.get(i)));
        }

        return articleDTOS;
    }
}
