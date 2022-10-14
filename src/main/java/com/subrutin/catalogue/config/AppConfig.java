package com.subrutin.catalogue.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.subrutin.catalogue.domain.Author;
import com.subrutin.catalogue.domain.Book;
import com.subrutin.catalogue.repository.BookRepository;
import com.subrutin.catalogue.repository.impl.BookRepositoryImpl;

@Configuration
public class AppConfig {

	@Bean
	public Author author() {
		return new Author(1L, "Stephanie Mayer", 9739L);
	}
	
	@Bean
	// getter setter dapat langsung diakses karena anotasi @Data pada class Book
	public Book book1(Author author) {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("Twilight");
		book.setDescription("Buku kesatu seri twilight");
		book.setAuthor(author);
		return book;
	}
	
	@Bean
	// getter setter dapat langsung diakses karena anotasi @Data pada class Book
	public Book book2(Author author) {
		Book book = new Book();
		book.setId(2L);
		book.setTitle("New Moon");
		book.setDescription("Buku kedua seri twilight");
		book.setAuthor(author);
		return book;
	}
	
	@Bean 
	public BookRepository bookRepository(Book book1, Book book2) {
		Map<Long, Book> bookMap = new HashMap<Long, Book>();
		bookMap.put(1L, book1);
		bookMap.put(2L, book2);
		
		BookRepositoryImpl bookRepository = new BookRepositoryImpl();
		bookRepository.setBookMap(bookMap);
		
		return bookRepository;
	}
}
