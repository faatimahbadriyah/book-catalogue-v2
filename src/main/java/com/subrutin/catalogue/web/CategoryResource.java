package com.subrutin.catalogue.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.subrutin.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.subrutin.catalogue.service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CategoryResource {
	
	private final CategoryService categoryService;
	
	@PostMapping("/v1/category")
	public ResponseEntity<Void> createAndUpdateCategory(@RequestBody CategoryCreateUpdateRequestDTO dto){
		categoryService.createAndUpdateCategory(dto);
		return ResponseEntity.created(URI.create("/v1/category")).build();
	} 

}
