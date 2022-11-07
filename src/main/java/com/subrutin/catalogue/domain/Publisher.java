package com.subrutin.catalogue.domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5967251835452724352L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
	@SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq")
	private Long id;
	
	@Column(name = "secure_id", nullable = false, unique = false)
	private String secureId = UUID.randomUUID().toString();
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "company_name", nullable = false)	
	private String companyName;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "publisher")
	private List<Book> books;
	
	@Column(name = "deleted", columnDefinition = "boolean default false")
	private Boolean deleted;
}
