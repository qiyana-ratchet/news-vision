package com.example.newsvision.support;

import org.springframework.stereotype.Component;

@Component
public class ArticleProcessing {

    public String articleProcess(String origin) throws Exception{

        String result;
        result = origin.replaceAll("\\(.*\\)", "")
                .replaceAll("\\[.*\\]", "")
                .replaceAll("\\{.*\\}", "")
                .replaceAll("%", "퍼센트")
                .replaceAll("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z0-9,.!? ]", "");

        return result;
    }
}
