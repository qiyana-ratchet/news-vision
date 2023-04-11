package com.example.newsvision.controller;

import com.example.newsvision.dto.ArticleCommand;
import com.example.newsvision.dto.ArticleDTO;
import com.example.newsvision.service.NewsVisionService;
import com.example.newsvision.support.ArticleDTOConverter;
import com.example.newsvision.support.ArticleProcessing;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class NewsVisionRestController {

    @Autowired
    private NewsVisionService newsVisionService;
    @Autowired
    private ArticleDTOConverter articleDTOConverter;

    @PostMapping("/postArticle")
    public ResponseEntity<List<ObjectError>> postText(@RequestHeader HttpHeaders qHeaders,
                                                      @Valid @RequestBody ArticleCommand articleCommand,
                                                      BindingResult bindingResult) throws Exception {

        //if the submitted data has any validation error
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON).body(bindingResult.getAllErrors());
        }

        ArticleDTO articleDTO;
        try{
            articleDTO = articleDTOConverter.toDTOFromCommand(articleCommand);
            articleDTO = newsVisionService.createArticle(articleDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON).body(null);
        }

        //if the request has succeed
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(null);
    }
}
