package com.ted.stream.mongo.service;

import java.util.List;

import com.ted.stream.mongo.entity.Message;

public interface MessageService {
    
    Message createMessage(Message message);
    Message updateMessage(Message message);
    void deleteMessage(String id);
    List<Message> findMessageByCategoryName(String name);
    List<Message> findMessagebyUserUsername(String username);
    List<Message> findAll();
    void removeAll();
}
