package com.adriencheynet.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adriencheynet.blog.model.Post;
import com.adriencheynet.blog.service.PostService;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable("id") final long id) {
		Optional<Post> post = postService.getPost(id);
		if(post.isPresent()) {
			return post.get();
		} else {
			return null;
		}
    }
    
    @GetMapping("/posts")
    public Iterable<Post> getPosts() {
        return postService.getPosts();
    }
}
