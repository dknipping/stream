package com.ted.stream.service;

import java.util.List;

import com.ted.stream.entity.Book;
import com.ted.stream.entity.Category;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public interface BookService {
	
	public void addBook(Book book);
	
	public void removeBook(String isbn);
	
	public Book findBookByISBN(String isbn);
	
	public List<Book> findBooksByTitle(String title);
	
	public List<Book> findBooksByAuthor(String author);
	
	public List<Book> findBooksByCategory(Category category);
	
	public void removeAll();
	
	public List<Book> findAll();

}
