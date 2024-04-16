package com.adriencheynet.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriencheynet.blog.model.Keyword;
import com.adriencheynet.blog.service.KeywordService;

@RestController
public class KeywordController {
    
    @Autowired
    private KeywordService keywordService;

    @GetMapping("public/keywords")
    public Iterable<Keyword> getKeywords() {
        return keywordService.getKeywords();
    }

}
