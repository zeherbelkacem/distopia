package com.fms.distopia.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.distopia.entities.Movie;
import com.fms.distopia.service.ICategoryService;
import com.fms.distopia.service.ICinemaService;
import com.fms.distopia.service.IMovieService;

@Controller
public class DistopiaController {
	
	private IMovieService movieService;
	private ICategoryService categoryService;
	private ICinemaService cinemaService;
	
	
	public DistopiaController(IMovieService movieService, ICategoryService categoryService,
			ICinemaService cinemaService) {
		this.movieService = movieService;
		this.categoryService = categoryService;
		this.cinemaService = cinemaService;
	}


	@GetMapping("")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
	@RequestParam(name = "size", defaultValue = "4") int size,
	@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
	@RequestParam(name = "cinName", defaultValue = "") String cinName) {
		
		Page<Movie> movies;
		
		movies = movieService.findByPagesAndByTitleAndClassification(keyWord, PageRequest.of(page, size));
		System.out.println(movies.getContent().get(0).getDescription());
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[movies.getTotalPages()]);
		model.addAttribute("totalPages", movies.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("movies", movies.getContent());
		return "home";
	}

}
