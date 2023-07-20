package com.subrutin.catalogue.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class AuthorUpdateRequestDTO {
	
	private String authorName;
	
	private Long birthDate;

	private List<AddressUpdateRequestDTO> addresses;
}
