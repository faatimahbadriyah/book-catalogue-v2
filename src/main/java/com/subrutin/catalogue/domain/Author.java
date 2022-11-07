package com.subrutin.catalogue.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author", indexes = {
		@Index(name = "uk_secure_id", columnList = "secure_id")
})
@DynamicUpdate
@Where(clause = "deleted=false")
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
public class Author implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1333310325669325406L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "author_id_seq")
	private Long id;
	
	@Column(name = "secure_id", nullable = false, unique = false)
	private String secureId = UUID.randomUUID().toString();
	
	@Column(name = "author_name", nullable = false, columnDefinition = "varchar(300)")
	private String name;
	
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;
	
	@Column(name = "deleted", columnDefinition = "boolean default false")
	private Boolean deleted;
	
}
