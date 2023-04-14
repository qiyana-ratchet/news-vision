package com.example.newsvision.controller;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.service.NewsVisionService;
import com.example.newsvision.support.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/news")
public class NewsVisionRestController {

    @Autowired
    private NewsVisionService newsVisionService;
    @Autowired
    private ArticleDTOConverter articleDTOConverter;
    @Autowired
    private ArticleApiProcessor articleApiProcessor;
    @Autowired
    private VideoProcessor videoProcessor;
    @Autowired
    private ArticleTextProcessor articleTextProcessor;
    @Autowired
    private ArticleTranslator articleTranslator;
    @Autowired
    private ArticleGenreResolver articleGenreResolver;


    /**
     * test 하면 기사 10개가 동시에 repository에 저장.
     */
    @GetMapping("api-test")
    public void initTest() {
        List<ArticleDTO> articleDTOS;
        String str = articleApiProcessor.getApiArticle();
        try {
            articleDTOS = articleDTOConverter.articleApiStrToDTOs(str);
            articleDTOS = articleTranslator.translate(articleDTOS);
            articleDTOS = articleTextProcessor.articleProcess(articleDTOS);
            articleDTOS = articleGenreResolver.resolveGenre(articleDTOS);
            newsVisionService.saveArticles(articleDTOS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 기사 ID로 기사 1개 가져오기
     */
    @GetMapping("/article")
    public ResponseEntity<ArticleDTO> getOneArticle(@RequestHeader HttpHeaders qHeaders,
                                                    @RequestParam("id") Integer id) throws Exception {

        if(id == null)  return ResponseEntity.badRequest().body(null);

        ArticleDTO articleDTO = null;
        try{
            articleDTO = newsVisionService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(articleDTO);
    }

    /**
     * 기사 ID로 영상 경로 가져오기
     */
    @PatchMapping("/video/{id}")
    public ResponseEntity<HashMap<String, String>> getVideo(@RequestHeader HttpHeaders qHeaders,
                                @PathVariable("id") Integer id) throws Exception {

        if(id == null)  return ResponseEntity.badRequest().body(null);

        URI videoPath = null;
        try {
            ArticleDTO articleDTO = newsVisionService.findById(id);
            videoPath = videoProcessor.videoProcess(articleDTO);
            newsVisionService.updateVideoPath(articleDTO);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("URI", videoPath.getPath());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(hashMap);
    }

    /**
     * 페이지 번호로 기사 리스트(페이지) 가져오기
     */
    @GetMapping("/list")
    public ResponseEntity<?> getPage(@RequestHeader HttpHeaders qHeaders,
                                     @RequestParam("page") Integer page) throws Exception {

        if(page == null)  return ResponseEntity.badRequest().body(null);
        //구현
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(null);
    }


//    /**
//     * Entity 전부 반환; 추후에 DTO로 바꿔서 변환,
//     * @return
//     */
//    @GetMapping("find-all")
//    public List<Article> findAll() {
//        List<Article> articles = articleRepository.findAll();
//        return articles;
//    }


//    @GetMapping("/list")
//    public ResponseEntity<?> getNews(@RequestHeader HttpHeaders qHeaders,
//                                @Valid @ModelAttribute ArticleCommand articleCommand,
//                                BindingResult bindingResult) throws Exception {
//
//    }
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
//                //if the request has succeeded
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(null);
//    }

}