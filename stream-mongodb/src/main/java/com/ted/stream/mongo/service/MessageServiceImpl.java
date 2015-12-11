package com.ted.stream.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ted.stream.mongo.entity.Message;
import com.ted.stream.mongo.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {
    
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(String id) {
        messageRepository.delete(id);
    }

    @Override
    public List<Message> findMessageByCategoryName(String name) {
        return messageRepository.findMessageByCategoryName(name);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> findMessagebyUserUsername(String username) {
        return messageRepository.findMessageByUserUsername(username);
    }

    @Override
    public void removeAll() {
        messageRepository.deleteAll();
    }
}
