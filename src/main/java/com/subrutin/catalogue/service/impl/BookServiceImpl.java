package com.subrutin.catalogue.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Author;
import com.subrutin.catalogue.domain.Book;
import com.subrutin.catalogue.domain.Category;
import com.subrutin.catalogue.domain.Publisher;
import com.subrutin.catalogue.dto.BookCreateDTO;
import com.subrutin.catalogue.dto.BookDetailDTO;
import com.subrutin.catalogue.dto.BookUpdateRequestDTO;
import com.subrutin.catalogue.exception.BadRequestException;
import com.subrutin.catalogue.repository.BookRepository;
import com.subrutin.catalogue.service.AuthorService;
import com.subrutin.catalogue.service.BookService;
import com.subrutin.catalogue.service.CategoryService;
import com.subrutin.catalogue.service.PublisherService;

import lombok.AllArgsConstructor;

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
	public BookDetailDTO findBookDetailById(Long bookId) {
		Book book = bookRepository.findById(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
		BookDetailDTO dto = new BookDetailDTO();
		dto.setBookId(book.getId());
//		dto.setAuthorName(book.getAuthor().getName());
		dto.setBookTitle(book.getTitle());
		dto.setBookDescription(book.getDescription());
		return dto;
	}

	@Override
	public List<BookDetailDTO> findBookListDetail() {
		List<Book> books = bookRepository.findAll();
		return books.stream().map((b) -> {
			BookDetailDTO dto = new BookDetailDTO();
//			dto.setAuthorName(b.getAuthor().getName());
			dto.setBookDescription(b.getDescription());
			dto.setBookId(b.getId());
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
		bookRepository.save (book);

	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}
}
