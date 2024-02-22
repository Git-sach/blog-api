package com.adriencheynet.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "keyword")
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    // @ManyToMany(fetch = FetchType.EAGER,
    // cascade = CascadeType.ALL, mappedBy = "keywords")
    // Set<Post> posts = new HashSet<>();
}
