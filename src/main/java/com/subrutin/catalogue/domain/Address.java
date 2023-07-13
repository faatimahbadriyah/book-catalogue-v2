package com.subrutin.catalogue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLong;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@Column(name = "city_name", nullable = false)
	private String cityName;
	
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	@ManyToOne(fetch = FetchType.LAZY) //untuk efesiensi -> data penulis jarang didapat dari address
	@JoinColumn(name = "author_id", nullable = false)
	private Author author;
	
}
