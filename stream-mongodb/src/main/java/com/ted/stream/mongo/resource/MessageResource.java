package com.ted.stream.mongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ted.stream.mongo.entity.Message;
import com.ted.stream.mongo.service.MessageService;

/**
 * 
 * @author dknipping
 *
 */
@RestController
public class MessageResource {

    @Autowired
    private MessageService messageService;
    
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(messageService.findAll());
    }
    
    @RequestMapping(value = "/messages/users", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getMessagesByUsername(@RequestParam(required = true) String username) {
        return ResponseEntity.ok(messageService.findMessageByUserUsername(username));
    }
    
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
    public ResponseEntity<Message> getMessage(@PathVariable String id) {
        return ResponseEntity.ok(messageService.findMessageById(id));
    }
    
    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public ResponseEntity<Message> saveMessage(@RequestBody Message Message) {
        return new ResponseEntity<Message>(messageService.createMessage(Message), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Message> updateMessage(@PathVariable String id, @RequestBody Message Message) {
        return ResponseEntity.ok(messageService.updateMessage(Message));
    }
    
    @RequestMapping(value = "/messages/{id}", method = RequestMethod.DELETE)
    public Object deleteMessage(@PathVariable String id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent();
    }
}
