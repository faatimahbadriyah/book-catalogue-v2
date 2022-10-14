package com.subrutin.catalogue.repository;

import com.subrutin.catalogue.domain.Book;

public interface BookRepository {
	
	public Book findBookById(Long id);

}
