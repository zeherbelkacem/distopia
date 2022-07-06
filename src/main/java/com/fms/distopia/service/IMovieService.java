package com.fms.distopia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.Movie;

public interface IMovieService {

	public List<Movie> readAllMovies();

	public Page<Movie> findByPagesAndByTitleAndClassification(String title, Pageable pageable);

}
