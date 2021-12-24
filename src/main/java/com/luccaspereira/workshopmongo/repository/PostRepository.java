package com.luccaspereira.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luccaspereira.workshopmongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{
}
