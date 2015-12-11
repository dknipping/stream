package com.ted.stream;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ted.stream.Application;
import com.ted.stream.entity.Book;
import com.ted.stream.entity.Category;
import com.ted.stream.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookServiceTest {

	@Autowired
	private BookService bookService;

	@Test
	public final void test1RemoveAll1() {
		bookService.removeAll();
		List<Book> allBooks = bookService.findAll();
		Assert.assertNotNull(allBooks);
		Assert.assertTrue(allBooks.isEmpty());
	}

	@Test
	public final void test2AddBook1() {
		Book book = new Book("Emil und die Detektive", "978-3791530123");
		book.getAuthors().add("Erich Kästner");
		bookService.addBook(book);
	}

	@Test
	public final void test3AddBook2() {
		Book book = new Book("Alice's Adventures in Wonderland", "978-1447279990");
		book.getAuthors().add("Lewis Carroll");
		book.getCategories().add(new Category("children"));
		book.getCategories().add(new Category("classics"));
		bookService.addBook(book);
	}

	@Test
	public final void test4AddBook3() {
		Book book = new Book("Der Verdacht", "978-3257214369");
		book.getAuthors().add("Friedrich Dürrenmatt");
		book.getCategories().add(new Category("detective"));
		book.getCategories().add(new Category("classics"));
		bookService.addBook(book);
	}

	@Test
	public final void test5AddBook4() {
		Book book = new Book("Animal Farm", "978-3257214xxx");
		book.getCategories().add(new Category("classics"));
		bookService.addBook(book);
	}

	@Test
	public final void test6AddBook5() {
		Book book = new Book("Clean Code", "978-0-13-235088-4");
		book.setSubtitle("A Handbook of Agile Software Craftsmanship");
		bookService.addBook(book);
	}

	@Test
	public final void test7FindAll() {
		List<Book> books = bookService.findAll();
		Assert.assertNotNull(books);
		Assert.assertFalse(books.isEmpty());
		Assert.assertEquals(5, books.size());
	}

	@Test
	public final void test8FindBookByISBN() {
		Book book = bookService.findBookByISBN("978-0-13-235088-4");
		Assert.assertNotNull(book);
		Assert.assertEquals("Clean Code", book.getTitle());
	}

	@Test
	public final void test90FindBooksByTitle() {
		List<Book> books = bookService.findBooksByTitle("Animal Farm");
		Assert.assertNotNull(books);
		Assert.assertFalse(books.isEmpty());
		Assert.assertEquals(1, books.size());
		Assert.assertEquals("978-3257214xxx", books.get(0).getIsbn());
	}

	@Test
	public final void test91FindBooksByAuthor() {
		List<Book> books = bookService.findBooksByAuthor("Erich Kästner");
		Assert.assertNotNull(books);
		Assert.assertFalse(books.isEmpty());
		Assert.assertEquals(1, books.size());
		Assert.assertEquals("Emil und die Detektive", books.get(0).getTitle());
	}

	@Test
	public final void test92FindBooksByCategory() {
		List<Book> classicBooks = bookService.findBooksByCategory(new Category("classics"));
		Assert.assertNotNull(classicBooks);
		Assert.assertFalse(classicBooks.isEmpty());
		Assert.assertEquals(3, classicBooks.size());
	}

	@Test
	public final void test93RemoveBook() {
		bookService.removeBook("978-0-13-235088-4");
		Book book = bookService.findBookByISBN("978-0-13-235088-4");
		Assert.assertNull(book);
	}

	@Test
	public final void test94RemoveAll2() {
		bookService.removeAll();
		List<Book> allBooks = bookService.findAll();
		Assert.assertNotNull(allBooks);
		Assert.assertTrue(allBooks.isEmpty());
	}

}
