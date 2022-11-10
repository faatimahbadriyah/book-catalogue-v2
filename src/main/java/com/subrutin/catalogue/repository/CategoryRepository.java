package com.subrutin.catalogue.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.catalogue.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{
	
	public Optional<Category> findByCode(String code);

}
