package com.subrutin.catalogue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.subrutin.catalogue.dto.BookDetailDTO;
import com.subrutin.catalogue.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class BookResource {

	Logger log = LoggerFactory.getLogger(HelloResources.class);

	private final BookService bookService;
	
	@GetMapping("/book/{bookId}")
	public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
		StopWatch stopWatch = new StopWatch();
		log.info("start find book detail" + id);
		stopWatch.start();
		BookDetailDTO result = bookService.findBookDetailById(id);
		log.info("finish find book detail. execution time = {}", stopWatch.getTotalTimeMillis());
		return result;
	}
	
}
