package com.ted.stream.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ted.stream.mongo.entity.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findMessageByCategoryName(String name);
    List<Message> findMessageByUserUsername(String username);
    List<Message> findAll();
}
