package com.subrutin.catalogue.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book_detail")
public class BookDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8863806621826983713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "settings")
	private String settings;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@OneToOne
	@JoinColumn(name = "book_id", nullable = false)
	private Book book;

}
