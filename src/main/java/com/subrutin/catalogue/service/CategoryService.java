package com.subrutin.catalogue.service;

import com.subrutin.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.subrutin.catalogue.dto.CategoryListResponseDTO;
import com.subrutin.catalogue.dto.ResultPageResponseDTO;

public interface CategoryService {
	
	public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);
	
	public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy, String direction, String categoryName);

}
