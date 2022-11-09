package com.subrutin.catalogue.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherCreateRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1354067690489764539L;

	@NotBlank
	private String publisherName;
	
	@NotBlank
	private String companyName;
	
	private String address;

}
