package com.subrutin.catalogue.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Author;
import com.subrutin.catalogue.dto.AuthorCreateRequestDTO;
import com.subrutin.catalogue.dto.AuthorResponseDTO;
import com.subrutin.catalogue.dto.AuthorUpdateRequestDTO;
import com.subrutin.catalogue.exception.BadRequestException;
import com.subrutin.catalogue.repository.AuthorRepository;
import com.subrutin.catalogue.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	@Override
	public AuthorResponseDTO findAuthorById(Long id) {
		// 1. fetch data from db
		Author author = authorRepository.findById(id).orElseThrow(() -> new BadRequestException("invalid.authorId"));

		// 2. parse to authorResponseDTO
		AuthorResponseDTO dto = new AuthorResponseDTO();
		dto.setAuthorName(author.getName());
		dto.setBirthDate(author.getBirthDate().toEpochDay());

		// 3. return
		return dto;
	}

	@Override
	public void createNewAuthor(List<AuthorCreateRequestDTO> dtos) {
		List<Author> authors = dtos.stream().map((dto) -> {
			Author author = new Author();
			author.setName(dto.getAuthorName());
			author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
			return author;
		}).collect(Collectors.toList());

		authorRepository.saveAll(authors);
	}

	@Override
	public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto) {
		Author author = authorRepository.findById(authorId)
				.orElseThrow(() -> new BadRequestException("invalid.authorId"));
		author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
		author.setBirthDate(
				dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
		authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(Long authorId) {
		// 1. select data
		// 2. delete
		//or
		// 1. delete
		authorRepository.deleteById(authorId);
	}

}
