package com.ted.stream.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ted.stream.mongo.entity.User;
import com.ted.stream.mongo.exception.AccessDeniedException;
import com.ted.stream.mongo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

    @Override
    public User login(String username, String password) {
        User findUserByUsernameAndPassword = repository.findUserByUsernameAndPassword(username, password);
        if (findUserByUsernameAndPassword == null) {
            throw new AccessDeniedException("Login failed");
        }
        return findUserByUsernameAndPassword;
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        repository.delete(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }

    @Override
    public User findUserById(String id) {
        return repository.findUserById(id);
    }
	
}
