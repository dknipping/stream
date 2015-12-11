package com.ted.stream.mongo.service;

import java.util.List;

import com.ted.stream.mongo.entity.Comment;

public interface CommentService {
    
    Comment createComment(Comment Comment);
    Comment updateComment(Comment Comment);
    void deleteComment(String id);
    List<Comment> findAll();
    void removeAll();
}
