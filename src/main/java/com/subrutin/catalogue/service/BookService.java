package com.subrutin.catalogue.service;

import java.util.List;

import com.subrutin.catalogue.dto.BookCreateDTO;
import com.subrutin.catalogue.dto.BookDetailResponseDTO;
import com.subrutin.catalogue.dto.BookUpdateRequestDTO;

public interface BookService {
	
	public BookDetailResponseDTO findBookDetailById(String id);
	
	public List<BookDetailResponseDTO> findBookListDetail();
	
	public void createNewBook(BookCreateDTO dto);
	
	public void updateBook(Long bookId, BookUpdateRequestDTO dto);
	
	public void deleteBook(Long bookId);

}
