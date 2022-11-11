package com.subrutin.catalogue.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = -493967282312085855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = true)
	private String title;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name = "book_author", joinColumns = {
			@JoinColumn(name = "book_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "author_id", referencedColumnName = "id") })
	private List<Author> authors;

	@ManyToMany
	@JoinTable(name = "book_category", joinColumns = {
			@JoinColumn(name = "book_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "category_id", referencedColumnName = "code") })
	private List<Category> categories;
}
