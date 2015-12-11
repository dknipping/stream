package com.ted.stream.mongo.service;

import java.util.List;

import com.ted.stream.mongo.entity.User;

/**
 * 
 * @author dknipping
 *
 */
public interface UserService {
	
    User login(String username, String password);
    
    User findUserById(String id);
    
    User updateUser(User user);
    
	User createUser(User user);
	
	void deleteUser(String id);
	
	List<User> findAll();

	void removeAll();
}
