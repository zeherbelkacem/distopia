package com.fms.distopia.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.Category;

public interface ICategoryService {

	void deleteCategory(String id);

	public Page<Category> readAllByPageAndKeyWord(Pageable pageable);

	public Category readByName(String id);

	void saveCategory(Category category);

}
