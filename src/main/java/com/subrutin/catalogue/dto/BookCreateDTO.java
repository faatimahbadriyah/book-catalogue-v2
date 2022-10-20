package com.subrutin.catalogue.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class BookCreateDTO {
	
	@NotBlank
	private String bookTitle;
	
	@NotBlank
	private String authorName;
	
	private String description;

}
