package com.ted.stream.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ted.stream.mongo.entity.Comment;
import com.ted.stream.mongo.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment Comment) {
        return commentRepository.save(Comment);
    }

    @Override
    public Comment updateComment(Comment Comment) {
        return commentRepository.save(Comment);
    }

    @Override
    public void deleteComment(String id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public void removeAll() {
        commentRepository.deleteAll();
    }
}
