package com.ted.stream.mongo.resource;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ted.stream.mongo.entity.AuthenticationRequest;
import com.ted.stream.mongo.service.UserService;

@RestController
public class AuthenticationResource {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        userService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        return new ResponseEntity<String>(UUID.randomUUID().toString(), HttpStatus.OK);
    }
}
