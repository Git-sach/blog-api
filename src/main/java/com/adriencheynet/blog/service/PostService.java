package com.adriencheynet.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriencheynet.blog.model.Post;
import com.adriencheynet.blog.repository.PostRepository;

import lombok.Data;

@Data
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
     
    public Optional<Post> getPost(final Long id) {
        return postRepository.findById(id);
    }

    public Iterable<Post> getPosts() {
        Iterable<Post> posts = postRepository.findAll();
        return posts;
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
