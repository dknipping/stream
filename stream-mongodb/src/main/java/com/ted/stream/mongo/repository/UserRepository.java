package com.ted.stream.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ted.stream.mongo.entity.User;

/**
 * 
 * @author dknipping
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	
	User findUserById(String id);
	User findUserByUsernameAndPassword(String username, String password);
}
