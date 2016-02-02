package com.ted.stream.mongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ted.stream.mongo.entity.Category;
import com.ted.stream.mongo.service.CategoryService;

/**
 * 
 * @author dknipping
 *
 */
@RestController
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getcategories() {
        return ResponseEntity.ok(categoryService.findAll());
    }
    
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> getUser(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.findUserById(id));
    }
    
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable String id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }
    
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public Object deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent();
    }
}
