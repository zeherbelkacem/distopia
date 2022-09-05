package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.Category;

public interface ICategoryService {

	/**
	 * 
	 * @param id
	 */
	void deleteCategory(String id);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<Category> readAllByPageAndKeyWord(Pageable pageable);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Category readByName(String id);

	/**
	 * 
	 * @param category
	 */
	void saveCategory(Category category);

	/**
	 * 
	 * @return
	 */
	public List<Category> readAllCategories();

}
