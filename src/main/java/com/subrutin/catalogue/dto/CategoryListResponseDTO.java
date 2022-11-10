package com.subrutin.catalogue.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryListResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4141179273174067319L;
	
	private String code;
	
	private String name;
	
	private String description;

}
