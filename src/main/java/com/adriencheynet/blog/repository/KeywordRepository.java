package com.adriencheynet.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adriencheynet.blog.model.Keyword;

@Repository
public interface KeywordRepository extends CrudRepository<Keyword, Long>{
    
}
