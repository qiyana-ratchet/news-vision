package com.example.newsvision.support;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class ArticleApiProcessor {

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
}
