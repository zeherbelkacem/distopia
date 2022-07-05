package com.fms.distopia.service;

import org.springframework.stereotype.Service;

import com.fms.distopia.repository.CinemaRepository;

@Service
public class CinemaServiceImpl implements ICinemaService{

	private CinemaRepository cinemaRepository;

	public CinemaServiceImpl(CinemaRepository cinemaRepository) {
		this.cinemaRepository = cinemaRepository;
	}
	
}
