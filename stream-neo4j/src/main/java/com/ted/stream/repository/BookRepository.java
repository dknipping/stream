package com.ted.stream.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.ted.stream.entity.Book;

public interface BookRepository extends GraphRepository<Book> {

	@Query("MATCH (b:Book) WHERE b.isbn = {0} RETURN b")
	List<Book> findByIsbn(String isbn);

	@Query("MATCH (b:Book) WHERE b.title = {0} RETURN b")
	List<Book> findByTitle(String title);
}
