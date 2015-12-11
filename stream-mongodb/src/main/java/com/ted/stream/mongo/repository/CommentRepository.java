package com.ted.stream.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ted.stream.mongo.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {

}
