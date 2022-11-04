package com.subrutin.catalogue.service;

import java.util.List;

import com.subrutin.catalogue.dto.AuthorCreateRequestDTO;
import com.subrutin.catalogue.dto.AuthorResponseDTO;
import com.subrutin.catalogue.dto.AuthorUpdateRequestDTO;

public interface AuthorService {
	
	public AuthorResponseDTO findAuthorById(Long id);
	
	public void createNewAuthor(List<AuthorCreateRequestDTO> dto);
	
	public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto);
	
	public void deleteAuthor(Long authorId);

}
