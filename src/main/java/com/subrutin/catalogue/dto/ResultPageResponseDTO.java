package com.subrutin.catalogue.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResultPageResponseDTO<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7955583640596413210L;

	private List<T> result;
	
	private Integer pages;
	
	private Long elements;

}
