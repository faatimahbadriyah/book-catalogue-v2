package com.subrutin.catalogue.repository;

import java.util.List;

import com.subrutin.catalogue.domain.Book;

public interface BookRepository {
	
	public Book findBookById(Long id);
	
	public List<Book> findAll();
	
	public void save(Book book);

}
