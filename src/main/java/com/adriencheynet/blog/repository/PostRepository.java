package com.adriencheynet.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adriencheynet.blog.model.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    
}