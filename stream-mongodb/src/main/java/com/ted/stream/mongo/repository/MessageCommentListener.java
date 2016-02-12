package com.ted.stream.mongo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.ted.stream.mongo.entity.Comment;
import com.ted.stream.mongo.entity.Message;

@Component
public class MessageCommentListener extends AbstractMongoEventListener<Message> {
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Message> event) {
        Message source = event.getSource();
        List<Comment> comments = source.getComments();
        if (comments != null) {
            for (Comment comment : comments) {
                if (comment.getId() == null) {
                    Comment persistedComment = commentRepository.save(comment);
                    comment.setId(persistedComment.getId());
                }
            }
        }
        super.onBeforeConvert(event);
    }
}
