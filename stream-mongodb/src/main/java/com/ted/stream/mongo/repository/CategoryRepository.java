package com.ted.stream.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ted.stream.mongo.entity.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
