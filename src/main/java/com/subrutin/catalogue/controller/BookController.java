package com.subrutin.catalogue.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subrutin.catalogue.dto.BookCreateDTO;
import com.subrutin.catalogue.dto.BookDetailDTO;
import com.subrutin.catalogue.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	@GetMapping("/list")
	public String findBookList(Model model) {
		List<BookDetailDTO> books = bookService.findBookListDetail();
		model.addAttribute("books", books);
		return "book/list";
	}

	@GetMapping("/new")
	public String loadBookForm(Model model) {
		BookCreateDTO dto = new BookCreateDTO();
		model.addAttribute("bookCreateDTO", dto);
		return "book/new";
	}

	@PostMapping("/new")
	public String addNewBook(@ModelAttribute("bookCreateDTO") @Valid BookCreateDTO dto, 
			BindingResult bindingResult, 
			Errors errors,
			Model model) {
		if(errors.hasErrors()) {
			model.addAttribute("bookCreateDTO", dto);
			return "book/new";
		}
		bookService.createNewBook(dto);
		return "redirect:/book/list";
	}

}
