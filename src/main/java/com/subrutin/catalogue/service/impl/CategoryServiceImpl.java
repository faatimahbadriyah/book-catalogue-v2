package com.subrutin.catalogue.service.impl;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Category;
import com.subrutin.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.subrutin.catalogue.repository.CategoryRepository;
import com.subrutin.catalogue.service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository categoryRepository;
	
	@Override
	public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto) {
		
		Category category = categoryRepository.findByCode(dto.getCode().toLowerCase()).orElse(new Category());
		if(category.getCode() == null) {
			category.setCode(dto.getCode().toLowerCase()); //new
		}
		category.setName(dto.getName());
		category.setDescription(dto.getDescription());
		
		categoryRepository.save(category);		
	}
	
	

}
