package com.ted.stream.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ted.stream.entity.Book;
import com.ted.stream.entity.Category;
import com.ted.stream.repository.BookRepository;

/**
 * @author dknipping
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repo;
	
	@Override
	public void addBook(Book book) {
		repo.save(book);
	}

	@Override
	public void removeBook(String isbn) {
		List<Book> byIsbn = repo.findByIsbn(isbn);
		repo.delete(byIsbn);
	}

	@Override
	public Book findBookByISBN(String isbn) {
		List<Book> findByIsbn = repo.findByIsbn(isbn);
		if (findByIsbn != null && findByIsbn.size() > 0) {
			return findByIsbn.get(0);
		}
		return null;
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		return repo.findByTitle(title);
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		return null;
	}

	@Override
	public List<Book> findBooksByCategory(Category category) {
		return null;
	}

	@Override
	public void removeAll() {
		repo.deleteAll();
	}

	@Override
	@Transactional
	public List<Book> findAll() {
		Iterator<Book> iterator = repo.findAll().iterator();
		List<Book> books = new ArrayList<>();
		while (iterator.hasNext()) {
			books.add(iterator.next());
		}
		return books;
	}
	
}
