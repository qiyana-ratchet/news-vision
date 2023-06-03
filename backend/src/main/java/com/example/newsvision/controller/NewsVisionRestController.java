package com.example.newsvision.controller;

import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.enums.Genre;
import com.example.newsvision.service.NewsVisionService;
import com.example.newsvision.support.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    private ArticleGenreResolver articleGenreResolver;


    /**
     * test 하면 기사 10개가 동시에 repository에 저장.
     */
    @GetMapping("api-test")
    public void initTest() {
        List<ArticleDTO> articleDTOS;
        //String str = articleApiProcessor.getApiArticle(LocalDate.now());
        String str = articleApiProcessor.getApiArticle(LocalDate.of(2023, 6, 01));
        try {
            articleDTOS = articleDTOConverter.articleApiStrToDTOs(str);
            articleDTOS = articleTextProcessor.articleProcess(articleDTOS);
            //articleDTOS = articleGenreResolver.resolveGenre(articleDTOS);

            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            for(ArticleDTO articleDTO : articleDTOS){
                switch(random.nextInt(7)){
                    case 0:
                        articleDTO.setGenre(Genre.POLITICS);
                        break;
                    case 1:
                        articleDTO.setGenre(Genre.ECONOMY);
                        break;
                    case 2:
                        articleDTO.setGenre(Genre.SCIENCE);
                        break;
                    default:
                        articleDTO.setGenre(Genre.MISCELLANEOUS);
                }
            }

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
                                                    @RequestParam("id") Integer id) {

        if(id == null)  return ResponseEntity.badRequest().body(null);

        ArticleDTO articleDTO;
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
//    @GetMapping("/video/{id}")
//    public ResponseEntity<HashMap<String, String>> getVideo(@RequestHeader HttpHeaders qHeaders,
//                                @PathVariable("id") Integer id) {
//
//        if(id == null)  return ResponseEntity.badRequest().body(null);
//
//        String videoPath = "";
//        int sFlag = 0;
//        ArticleDTO articleDTO = null;
//        try {
//            synchronized (newsVisionService){
//                articleDTO = newsVisionService.findById(id);
//                if(articleDTO.getVideoPath() == null){
//                    articleDTO.setVideoPath("Pending");
//                    newsVisionService.updateArticle(articleDTO);
//                    sFlag = 1;
//                }
//                else if(articleDTO.getVideoPath().equals("Pending")){
//                    sFlag = 2;
//                }
//                else{
//                    sFlag = 3;
//                }
//            }
//
//            if(sFlag == 1){
//                videoPath = videoProcessor.videoProcess(articleDTO);
//                articleDTO.setVideoPath(videoPath);
//                newsVisionService.updateArticle(articleDTO);
//            }
//            else if(sFlag == 3){
//                videoPath = articleDTO.getVideoPath();
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            if(articleDTO != null){
//                try{
//                    articleDTO.setVideoPath(null);
//                    newsVisionService.updateArticle(articleDTO);
//                }catch (Exception e2){
//                    e2.printStackTrace();
//                }
//            }
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//
//        HashMap<String, String> hashMap = new HashMap<>();
//        switch(sFlag){
//            case 1, 3:
//                hashMap.put("URI", videoPath);
//                break;
//            case 2:
//                hashMap.put("URI", "Pending");
//                break;
//            default:
//                hashMap.put("URI", "Video Error");
//        }
//
//        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(hashMap);
//    }

    @GetMapping("/video/{id}")
    public ResponseEntity<FileSystemResource> getVideo(@RequestHeader HttpHeaders qHeaders,
                                                            @PathVariable("id") Integer id) throws IOException {

        if(id == null)  return ResponseEntity.badRequest().body(null);

        String videoPath = "";
        int sFlag = 0;
        ArticleDTO articleDTO = null;
        try {
            synchronized (newsVisionService){
                articleDTO = newsVisionService.findById(id);
                if(articleDTO.getVideoPath() == null){
                    articleDTO.setVideoPath("Pending");
                    newsVisionService.updateArticle(articleDTO);
                    sFlag = 1;
                }
                else if(articleDTO.getVideoPath().equals("Pending")){
                    sFlag = 2;
                }
                else{
                    sFlag = 3;
                }
            }

            if(sFlag == 1){
                videoPath = videoProcessor.videoProcess(articleDTO);
                articleDTO.setVideoPath(videoPath);
                newsVisionService.updateArticle(articleDTO);
            }
            else if(sFlag == 3){
                videoPath = articleDTO.getVideoPath();
            }
        }catch(Exception e){
            e.printStackTrace();
            if(articleDTO != null){
                try{
                    articleDTO.setVideoPath(null);
                    newsVisionService.updateArticle(articleDTO);
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        FileSystemResource fileSystemResource;
        switch(sFlag){
            case 1, 3:
                fileSystemResource = new FileSystemResource(videoPath);
                break;
            default:
                fileSystemResource = null;
        }

        //qHeaders.setContentType(MediaType.parseMediaType("video/mp4"));
        qHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok().headers(qHeaders).body(fileSystemResource);
    }

    /**
     * 페이지 번호로 기사 리스트(페이지) 가져오기 -> /news/list?page=1
     */
    @GetMapping("/list")
    public ResponseEntity<Page<ArticleDTO>> getPage(@RequestHeader HttpHeaders qHeaders,
                                     @RequestParam("page") Integer pageNo) {

        if(pageNo == null)  return ResponseEntity.badRequest().body(null);

        pageNo = (pageNo == 0) ? 0 : (pageNo - 1);
        Page<ArticleDTO> articleDTOPage;
        try{
            articleDTOPage = newsVisionService.getPage(pageNo, Policy.pageSize);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(articleDTOPage);
    }
}