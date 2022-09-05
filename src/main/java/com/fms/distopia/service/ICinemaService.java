package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.Cinema;

public interface ICinemaService {

	/**
	 * 
	 * @return
	 */
	public List<Cinema> readAll();

	/**
	 * 
	 * @param keyWord
	 * @param pageable
	 * @return
	 */
	public Page<Cinema> readAllByPageAndKeyWord(String keyWord, Pageable pageable);

	/**
	 * 
	 * @param cinema_id
	 * @return
	 */
	public Cinema getCinemaById(Long cinema_id);

	/**
	 * 
	 * @param id
	 */
	public void deleteCategory(Long id);

	/**
	 * 
	 * @param cinema
	 */
	public void saveCinema(@Valid Cinema cinema);


}
