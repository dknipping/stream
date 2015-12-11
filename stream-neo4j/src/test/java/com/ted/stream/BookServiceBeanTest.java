package com.ted.stream;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ted.stream.Application;
import com.ted.stream.entity.Book;
import com.ted.stream.entity.Category;
import com.ted.stream.service.BookService;

@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceBeanTest {

	@Autowired
	private BookService service;
	
	@Test
	public void testSaveBook() {
		Book book = new Book();
		book.setIsbn("123");
		book.setSubtitle("Blub");
		book.setTitle("Das blub des bli bla");
		book.getAuthors().add("Hans");
		Category category = new Category();
		category.setName("Horror");
		book.getCategories().add(category);
		service.addBook(book);
		Book findBookByISBN = service.findBookByISBN("123");
		Assert.assertNotNull(findBookByISBN);
	}
	
}
