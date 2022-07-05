package com.fms.distopia.service;

import org.springframework.stereotype.Service;

import com.fms.distopia.repository.MovieRepository;

@Service
public class MovieServiceImpl implements IMovieService{
	
	private MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

}
