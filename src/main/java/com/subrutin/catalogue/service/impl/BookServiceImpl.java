package com.subrutin.catalogue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<BookDetailDTO> findBookListDetail() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map((b)->{
			BookDetailDTO dto = new BookDetailDTO();
			dto.setAuthorName(b.getAuthor().getName());
			dto.setBookDescription(b.getDescription());
			dto.setBookId(b.getId());
			dto.setBookTitle(b.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}
}
