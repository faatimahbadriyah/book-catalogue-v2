package com.subrutin.catalogue.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subrutin.catalogue.dto.BookCreateDTO;
import com.subrutin.catalogue.dto.BookDetailDTO;
import com.subrutin.catalogue.dto.BookUpdateRequestDTO;
import com.subrutin.catalogue.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {

	private final BookService bookService;

	@GetMapping("/book/{bookId}")
	public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
		StopWatch stopWatch = new StopWatch();
		log.info("start find book detail " + id);
		stopWatch.start();
		BookDetailDTO result = bookService.findBookDetailById(id);
		log.info("finish find book detail. execution time = {}", stopWatch.getTotalTimeMillis());
		return result;
	}

	@PostMapping("/book")
	public ResponseEntity<Void> createNewBook(@RequestBody BookCreateDTO dto) {
		bookService.createNewBook(dto);
		return ResponseEntity.created(URI.create("/book")).build();
	}

	@GetMapping("/book")
	public ResponseEntity<List<BookDetailDTO>> findBookList() {
		return ResponseEntity.ok().body(bookService.findBookListDetail());
	}

	@PutMapping("/book/{bookId}")
	public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId, 
			@RequestBody BookUpdateRequestDTO dto){
		bookService.updateBook(bookId, dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId){
		bookService.deleteBook(bookId);
		return ResponseEntity.ok().build();
	}
}
