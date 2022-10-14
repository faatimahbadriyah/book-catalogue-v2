package com.subrutin.catalogue.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.subrutin.catalogue.domain.Book;
import com.subrutin.catalogue.repository.BookRepository;

import lombok.Data;

@Data
public class BookRepositoryImpl implements BookRepository{
	
	private Map<Long, Book> bookMap;

	@Override
	public com.subrutin.catalogue.domain.Book findBookById(Long id) {
		Book book = bookMap.get(id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		List<Book> bookList = new ArrayList<Book>(bookMap.values());
		return bookList;
	}
}
