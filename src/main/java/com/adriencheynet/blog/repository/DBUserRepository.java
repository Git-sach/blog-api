package com.adriencheynet.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adriencheynet.blog.model.DBUser;

@Repository
public interface DBUserRepository extends CrudRepository<DBUser, Integer> {
    public DBUser findByUsername(String username);
}
