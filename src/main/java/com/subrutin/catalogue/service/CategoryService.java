package com.subrutin.catalogue.service;

import java.util.List;

import com.subrutin.catalogue.domain.Category;
import com.subrutin.catalogue.dto.CategoryCreateUpdateRequestDTO;
import com.subrutin.catalogue.dto.CategoryListResponseDTO;
import com.subrutin.catalogue.dto.ResultPageResponseDTO;

public interface CategoryService {
	
	public void createAndUpdateCategory(CategoryCreateUpdateRequestDTO dto);
	
	public ResultPageResponseDTO<CategoryListResponseDTO> findCategoryList(Integer pages, Integer limit, String sortBy, String direction, String categoryName);
	
	public List<Category> findCategories(List<String> categoryCodeList);

}
