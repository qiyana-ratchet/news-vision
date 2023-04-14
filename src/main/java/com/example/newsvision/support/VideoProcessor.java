package com.example.newsvision.support;

import com.example.newsvision.dto.ArticleDTO;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class VideoProcessor {

    public URI videoProcess(ArticleDTO articleDTO) throws Exception{
        if(articleDTO == null) throw new IllegalArgumentException("no articleDTO");
        URI uri = null;

        //구현
        return uri;
    }
}
