package com.subrutin.catalogue.service;

import java.util.List;

import com.subrutin.catalogue.dto.BookCreateDTO;
import com.subrutin.catalogue.dto.BookDetailDTO;
import com.subrutin.catalogue.dto.BookUpdateRequestDTO;

public interface BookService {
	
	public BookDetailDTO findBookDetailById(Long id);
	
	public List<BookDetailDTO> findBookListDetail();
	
	public void createNewBook(BookCreateDTO dto);
	
	public void updateBook(Long bookId, BookUpdateRequestDTO dto);
	
	public void deleteBook(Long bookId);

}
