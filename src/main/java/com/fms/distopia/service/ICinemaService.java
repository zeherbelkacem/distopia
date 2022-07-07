package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.Cinema;

public interface ICinemaService {

	public List<Cinema> readAll();

	public Page<Cinema> readAllByPageAndKeyWord(String keyWord, Pageable pageable);

	public Cinema getCinemaById(Long cinema_id);

	public void deleteCategory(Long id);

	public void saveCinema(@Valid Cinema cinema);


}
