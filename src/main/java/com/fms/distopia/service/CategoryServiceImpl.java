package com.fms.distopia.service;

import org.springframework.stereotype.Service;

import com.fms.distopia.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

}
