package com.ted.stream.mongo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.mongodb.core.convert.LazyLoadingProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ted.stream.mongo.entity.Category;
import com.ted.stream.mongo.entity.Comment;
import com.ted.stream.mongo.entity.Message;
import com.ted.stream.mongo.entity.User;
import com.ted.stream.mongo.service.CommentService;
import com.ted.stream.mongo.service.MessageService;
import com.ted.stream.mongo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MessageServiceTest {

    @Autowired
    private MessageService messageService;
    
    @Autowired
    private CommentService commentsService;
    
    @Autowired
    private UserService userService;
    
    @Before
    public void before() {
        userService.removeAll();
        messageService.removeAll();
        commentsService.removeAll();
    }
    
    @Test
    public void testMessageService() {
        User user = new User();
        user.setFirstName("Hans");
        user.setLastName("Müller");
        user.setPassword("test");
        user.setUsername("hmueller");
        user = userService.createUser(user);
        
        Category category = new Category();
        category.setName("Sport");
        
        Message message = new Message();
        message.setText("First message");
        message.setCategory(category);
        message.setUser(user);
        message.setPostDate(LocalDateTime.now());
        Message createdMessage = messageService.createMessage(message);
        assertNotNull(createdMessage);
        
        List<Message> findMessagebyUserUsername = messageService.findMessageByUserUsername("hmueller");
        assertEquals(1, findMessagebyUserUsername.size());
        
        List<Message> findMessageByCategoryName = messageService.findMessageByCategoryName("Sport");
        assertEquals(1, findMessageByCategoryName.size());
        
        messageService.deleteMessage(createdMessage.getId());
        assertEquals(0, messageService.findAll().size());
    }
    
    @Test
    public void testMessageServiceWithComments() {
        User user = new User();
        user.setFirstName("Hans");
        user.setLastName("Müller");
        user.setPassword("test");
        user.setUsername("hmueller");
        user = userService.createUser(user);

        User user2 = new User();
        user2.setFirstName("Hans");
        user2.setLastName("Müller");
        user2.setPassword("test");
        user2.setUsername("hmueller");
        user2 = userService.createUser(user2);
        
        Category category = new Category();
        category.setName("Sport");
        
        Message message = new Message();
        message.setText("First message");
        message.setCategory(category);
        message.setUser(user);
        message.setPostDate(LocalDateTime.now());
        
        Comment comment = new Comment();
        comment.setComment("Coole Sache");
        comment.setCommentDate(LocalDateTime.now());
        comment.setUser(user2);
        commentsService.createComment(comment);
        message.getComments().add(comment);
        
        Message createdMessage = messageService.createMessage(message);
        assertNotNull(createdMessage);
        
        List<Message> messages = messageService.findMessageByUserUsername("hmueller");
        List<Comment> comments = messages.get(0).getComments();
        assertTrue(comments instanceof LazyLoadingProxy);
        assertEquals(1, comments.size());
        
        messageService.deleteMessage(createdMessage.getId());
        assertEquals(0, messageService.findAll().size());
    }
    
}
