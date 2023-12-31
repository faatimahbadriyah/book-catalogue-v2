package com.subrutin.catalogue.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Address;
import com.subrutin.catalogue.domain.Author;
import com.subrutin.catalogue.dto.AuthorCreateRequestDTO;
import com.subrutin.catalogue.dto.AuthorResponseDTO;
import com.subrutin.catalogue.dto.AuthorUpdateRequestDTO;
import com.subrutin.catalogue.exception.BadRequestException;
import com.subrutin.catalogue.exception.ResourceNotFoundException;
import com.subrutin.catalogue.repository.AuthorRepository;
import com.subrutin.catalogue.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;

	@Override
	public AuthorResponseDTO findAuthorById(String id) {
		// 1. fetch data from db
		Author author = authorRepository.findBySecureId(id)
				.orElseThrow(() -> new ResourceNotFoundException("invalid.authorId"));

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
			List<Address> addresses = dto.getAddresses().stream().map(a -> {
				Address address = new Address();
				address.setCityName(a.getCityName());
				address.setStreetName(a.getStreetName());
				address.setZipCode(a.getZipCode());
				address.setAuthor(author);
				return address;
			}).collect(Collectors.toList());
			author.setAddresses(addresses);
			return author;
		}).collect(Collectors.toList());

		authorRepository.saveAll(authors);
	}

	@Override
	public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto) {
		Author author = authorRepository.findBySecureId(authorId)
				.orElseThrow(() -> new BadRequestException("invalid.authorId"));

		Map<Long, Address> addressMap = author.getAddresses().stream().map(a -> a)
				.collect(Collectors.toMap(Address::getId, Function.identity()));

		author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
		author.setBirthDate(
				dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));
		authorRepository.save(author);
	}

	@Override
	public void deleteAuthor(String authorId) {
		// 1. select data
		Author author = authorRepository.findBySecureId(authorId)
				.orElseThrow(() -> new BadRequestException("invalid.authorId"));
		// 2. delete
		authorRepository.delete(author);

		// or
		// 1. delete
		// authorRepository.deleteById(authorId);

		// soft delete
		// 1. select data deleted false
		// Author author =
		// authorRepository.findByIdAndDeletedFalse(authorId).orElseThrow(() -> new
		// BadRequestException("invalid.authorId"));
		// 2. update deleted = true
		// author.setDeleted(Boolean.TRUE);
		// authorRepository.save(author);
	}

	@Override
	public List<Author> findAuthors(List<String> authorIdList) {
		List<Author> authors = authorRepository.findBySecureIdIn(authorIdList);
		if (authors.isEmpty())
			throw new BadRequestException("author can't empty");
		return authors;
	}

	@Override
	public List<AuthorResponseDTO> constructDto(List<Author> authors) {
		return authors.stream().map((a) -> {
			AuthorResponseDTO dto = new AuthorResponseDTO();
			dto.setAuthorName(a.getName());
			dto.setBirthDate(a.getBirthDate().toEpochDay());
			return dto;
		}).collect(Collectors.toList());
	}

}
