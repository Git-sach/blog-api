package com.adriencheynet.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriencheynet.blog.model.Keyword;
import com.adriencheynet.blog.repository.KeywordRepository;

import lombok.Data;

@Data
@Service
public class KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    public Iterable<Keyword> getKeywords() {
        Iterable<Keyword> keywords = keywordRepository.findAll();
        return keywords;
    }
    
}
