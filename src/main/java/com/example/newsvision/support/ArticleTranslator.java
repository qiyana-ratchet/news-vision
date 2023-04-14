package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleTranslator {

    public ArticleDTO translate(ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");

        //구현
        return articleDTO;
    }

    public List<ArticleDTO> translate(List<ArticleDTO> articleDTOS) throws Exception{
        if(articleDTOS == null) throw new IllegalArgumentException("no articleDTOS");

        //구현
        return articleDTOS;
    }
}
