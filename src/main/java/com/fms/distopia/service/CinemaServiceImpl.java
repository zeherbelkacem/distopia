package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.distopia.entities.Cinema;
import com.fms.distopia.repository.CinemaRepository;

@Service
public class CinemaServiceImpl implements ICinemaService{

	private CinemaRepository cinemaRepository;

	public CinemaServiceImpl(CinemaRepository cinemaRepository) {
		this.cinemaRepository = cinemaRepository;
	}

	@Override
	public List<Cinema> readAll() {
		return cinemaRepository.findAll();
	}

	@Override
	public Page<Cinema> readAllByPageAndKeyWord(String keyWord, Pageable pageable) {
		return cinemaRepository.findByNameContains(keyWord, pageable);
	}

	@Override
	public Cinema getCinemaById(Long cinema_id) {
		return cinemaRepository.findById(cinema_id).get();
	}

	@Override
	public void deleteCategory(Long id) {
		cinemaRepository.deleteById(id);
	}

	@Override
	public void saveCinema(@Valid Cinema cinema) {
		cinemaRepository.save(cinema);
	}
	
}
