package com.example.newsvision.support;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ArticleApiProcessor {

    /**
     * API를 활용해서, JSON으로 받아온다.
     *
     */
    public String getApiArticle(LocalDate localDate) {
        String result = "";
        try {
            //날짜 포맷을 [20230423] 형식으로 변환
            String date = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
            String urlString = String.format(Policy.apiUrl, Policy.articleCountsByOneApi, date);
            URL url = new URL(urlString);
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
