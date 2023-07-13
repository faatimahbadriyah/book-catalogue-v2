package com.subrutin.catalogue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Author;
import com.subrutin.catalogue.domain.Book;
import com.subrutin.catalogue.domain.Category;
import com.subrutin.catalogue.domain.Publisher;
import com.subrutin.catalogue.dto.BookCreateDTO;
import com.subrutin.catalogue.dto.BookDetailResponseDTO;
import com.subrutin.catalogue.dto.BookUpdateRequestDTO;
import com.subrutin.catalogue.exception.BadRequestException;
import com.subrutin.catalogue.repository.BookRepository;
import com.subrutin.catalogue.service.AuthorService;
import com.subrutin.catalogue.service.BookService;
import com.subrutin.catalogue.service.CategoryService;
import com.subrutin.catalogue.service.PublisherService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

	// final ditujukan agar bookRepository hanya diset pada saat proses inisialisasi
	// bean bookService
	private final BookRepository bookRepository;

	private final AuthorService authorService;

	private final CategoryService categoryService;

	private final PublisherService publisherService;

	@Override
	public BookDetailResponseDTO findBookDetailById(String bookId) {
		log.info("=== start get data book ===");
		Book book = bookRepository.findBySecureId(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
		log.info("=== finish get data book ===");
		
		BookDetailResponseDTO dto = new BookDetailResponseDTO();
		dto.setBookId(book.getSecureId());
	
		log.info("=== start get data category ===");
		dto.setCategories(categoryService.constructDTO(book.getCategories()));
		log.info("=== finish get data category ===");
		
		log.info("=== start get data author ===");
		dto.setAuthors(authorService.constructDto(book.getAuthors()));
		log.info("=== finish get data author ===");
		
		log.info("=== start get data publisher ===");
		dto.setPublisher(publisherService.construDTO(book.getPublisher()));
		log.info("=== end get data publisher ===");
		
		dto.setBookTitle(book.getTitle());
		dto.setBookDescription(book.getDescription());
		return dto;
	}

	@Override
	public List<BookDetailResponseDTO> findBookListDetail() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map((b) -> {
			BookDetailResponseDTO dto = new BookDetailResponseDTO();
//			dto.setAuthorName(b.getAuthor().getName());
			dto.setBookDescription(b.getDescription());
//			dto.setBookId(b.getId());
			dto.setBookTitle(b.getTitle());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void createNewBook(BookCreateDTO dto) {
		List<Author> authors = authorService.findAuthors(dto.getAuthorIdList());
		List<Category> categories = categoryService.findCategories(dto.getCategoryList());
		Publisher publisher = publisherService.findPublisher(dto.getPublisherId());

		Book book = new Book();
		book.setAuthors(authors);
		book.setCategories(categories);
		book.setPublisher(publisher);
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());
		bookRepository.save(book);
	}

	@Override
	public void updateBook(Long bookId, BookUpdateRequestDTO dto) {
		// get book from repository
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));

		// update
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());

		// save
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}
}
