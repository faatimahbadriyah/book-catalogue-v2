package com.subrutin.catalogue.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressCreateRequestDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4213259052384342391L;

	private String streetName;
	
	private String cityName;
	
	private String zipCode;

}
