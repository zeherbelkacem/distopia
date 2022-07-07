package com.fms.distopia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.distopia.entities.Category;
import com.fms.distopia.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void deleteCategory(String id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public Page<Category> readAllByPageAndKeyWord(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public Category readByName(String id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> readAllCategories() {
		return categoryRepository.findAll();
	}

}
