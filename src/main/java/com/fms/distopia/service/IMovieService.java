package com.fms.distopia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.Movie;

public interface IMovieService {

	/**
	 * 
	 * @return
	 */
	public List<Movie> readAllMovies();

	/**
	 * 
	 * @param title
	 * @param pageable
	 * @return
	 */
	public Page<Movie> findByPagesAndByTitleAndClassification(String title, Pageable pageable);

	/**
	 * 
	 * @param id
	 */
	public void deleteMovieById(Long id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Movie readMovieById(Long id);

	/**
	 * 
	 * @param movie
	 * @return
	 */
	public Movie saveMovie(Movie movie);

	/**
	 * 
	 * @param string
	 * @return
	 */
	public Movie readMovieByTitle(String string);

}
