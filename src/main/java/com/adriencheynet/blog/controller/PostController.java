package com.adriencheynet.blog.controller;

import java.io.InputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adriencheynet.blog.model.Post;
import com.adriencheynet.blog.service.PostService;



@RestController
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("public/post/{id}")
    public Post getPost(@PathVariable("id") final long id) {
		Optional<Post> post = postService.getPost(id);
		if(post.isPresent()) {
			return post.get();
		} else {
			return null;
		}
    }
    
    @GetMapping("public/posts")
    public Iterable<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("private/post")
    public Post creatPost(@RequestBody Post post) {
        return postService.savePost(post);
    }
    

    // Faire un controller a part ?
    @GetMapping("public/image/{id}/{name}")
    public @ResponseBody ResponseEntity<InputStreamResource> getImage(@PathVariable("id") final long id, @PathVariable("name") final String name) {
      InputStream input = getClass().getResourceAsStream("/static/images/post_" + id + "/" + name);

      if (input == null) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }

      return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(new InputStreamResource(input));
    }
}
