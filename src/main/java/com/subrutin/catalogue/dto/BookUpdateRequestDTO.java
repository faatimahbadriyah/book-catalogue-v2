package com.subrutin.catalogue.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookUpdateRequestDTO {
	
	@NotBlank
	private String bookTitle;
	
	@JsonProperty("synopsis")
	private String description;

}
