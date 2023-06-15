package com.subrutin.catalogue.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6500748939044557461L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Override
	public String getAuthority() {
		return "ROLE_" + name;
	}

}
