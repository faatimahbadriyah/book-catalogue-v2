package com.subrutin.catalogue.service.impl;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Book;
import com.subrutin.catalogue.dto.BookDetailDTO;
import com.subrutin.catalogue.repository.BookRepository;
import com.subrutin.catalogue.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService{
	
	//final ditujukan agar bookRepository hanya diset pada saat proses inisialisasi bean bookService
	private final BookRepository bookRepository;

	@Override
	public BookDetailDTO findBookDetailById(Long bookId) {
		Book book = bookRepository.findBookById(bookId);
		BookDetailDTO dto = new BookDetailDTO();
		dto.setBookId(book.getId());
		dto.setAuthorName(book.getAuthor().getName());
		dto.setBookTitle(book.getTitle());
		dto.setBookDescription(book.getDescription());
		return dto;
	}
}
