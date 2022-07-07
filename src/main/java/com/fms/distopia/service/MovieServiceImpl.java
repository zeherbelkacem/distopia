package com.fms.distopia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.distopia.entities.Movie;
import com.fms.distopia.repository.MovieRepository;

@Service
public class MovieServiceImpl implements IMovieService{
	
	private MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> readAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Page<Movie> findByPagesAndByTitleAndClassification(String title, Pageable pageable) {
		
		return movieRepository.findByTitleContainsOrCategoryNameContains(title, pageable);
	}

	@Override
	public void deleteMovieById(Long id) {
		movieRepository.deleteById(id);
	}

}
