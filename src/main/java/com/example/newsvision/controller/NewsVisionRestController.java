package com.example.newsvision.controller;

import com.example.newsvision.dto.ArticleCommand;
import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.model.Article;
import com.example.newsvision.persistence.ArticleRepository;
import com.example.newsvision.service.NewsVisionService;
import com.example.newsvision.support.ArticleProcessing;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class NewsVisionRestController {

    @Autowired
    private NewsVisionService newsVisionService;

    private final ArticleRepository articleRepository;

    /**
     * test 하면 기사 10개가 동시에 repository에 저장.
     */
    @GetMapping("api-test")
    public void initTest(){
        String str = newsVisionService.getApiArticle();
        try{
            newsVisionService.saveArticle(str);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Entity 전부 반환; 추후에 DTO로 바꿔서 변환,
     * @return
     */
    @GetMapping("find-all")
    public List<Article> findAll(){
        List<Article> articles = articleRepository.findAll();
        return articles;
    }


//    @GetMapping("getArticle")
//    public String getArticleTest() {
//        ArticleDTO = newsVisionService
//    }

//    /    private ArticleDTOConverter articleDTOConverter;
//
//
//    @PostMapping("/postArticle")
//    public ResponseEntity<List<ObjectError>> postText(@RequestHeader HttpHeaders qHeaders,
//                                                      @Valid @RequestBody ArticleCommand articleCommand,
//                                                      BindingResult bindingResult) throws Exception {
//
//        //if the submitted data has any validation error
//        if(bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest()
//                    .contentType(MediaType.APPLICATION_JSON).body(bindingResult.getAllErrors());
//        }
//
//        ArticleDTO articleDTO;
//        try{
//            articleDTO = articleDTOConverter.toDTOFromCommand(articleCommand);
//            articleDTO = newsVisionService.createArticle(articleDTO);
//        }catch (Exception e){
//            return ResponseEntity.badRequest()
//                    .contentType(MediaType.APPLICATION_JSON).body(null);
//        }
//
//        //if the request has succeed
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(null);
//    }





}
