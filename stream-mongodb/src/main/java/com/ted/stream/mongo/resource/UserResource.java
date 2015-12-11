package com.ted.stream.mongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ted.stream.mongo.entity.User;
import com.ted.stream.mongo.service.UserService;

/**
 * 
 * @author dknipping
 *
 */
@RestController
public class UserResource {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(String id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Object deleteUser(String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok();
    }
}
