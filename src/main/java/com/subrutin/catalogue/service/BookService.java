package com.subrutin.catalogue.service;

import com.subrutin.catalogue.dto.BookDetailDTO;

public interface BookService {
	
	public BookDetailDTO findBookDetailById(Long id);

}
