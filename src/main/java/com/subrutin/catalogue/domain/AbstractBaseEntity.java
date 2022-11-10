package com.subrutin.catalogue.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Data
@MappedSuperclass
@Table(name = "author", indexes = {
		@Index(name = "uk_secure_id", columnList = "secure_id")
})
public class AbstractBaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8097887337174861596L;

	@Column(name = "secure_id", nullable = false, unique = false)
	private String secureId = UUID.randomUUID().toString();
	
	@Column(name = "deleted", columnDefinition = "boolean default false")
	private boolean deleted;

}
