package com.fms.distopia.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.distopia.entities.Cinema;
import com.fms.distopia.entities.City;
import com.fms.distopia.entities.Movie;
import com.fms.distopia.service.ICategoryService;
import com.fms.distopia.service.ICinemaService;
import com.fms.distopia.service.ICityService;
import com.fms.distopia.service.IMovieService;

@Controller
public class DistopiaController {

	private IMovieService movieService;
	private ICategoryService categoryService;
	private ICinemaService cinemaService;
	private ICityService cityService;

	public DistopiaController(IMovieService movieService, ICategoryService categoryService,
			ICinemaService cinemaService, ICityService cityService) {
		this.movieService = movieService;
		this.categoryService = categoryService;
		this.cinemaService = cinemaService;
		this.cityService = cityService;
	}

	@GetMapping("")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "cinema_id", defaultValue = "") Long cinema_id) {
		Page<Movie> movies;

		if (cinema_id != null) {
			List<Movie> moviesList = cinemaService.getCinemaById(cinema_id).getMovies();
			Pageable pageable = PageRequest.of(page, size);
			final int start = (int) pageable.getOffset();
			final int end = Math.min((start + pageable.getPageSize()), moviesList.size());
			movies = new PageImpl<>(moviesList.subList(start, end), pageable, moviesList.size());
		}else {
			movies = movieService.findByPagesAndByTitleAndClassification(keyWord, PageRequest.of(page, size));
		}
//		movies = movieService.findByPagesAndByTitleAndClassification(keyWord, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[movies.getTotalPages()]);
		model.addAttribute("totalPages", movies.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("movies", movies.getContent());
		return "home";
	}

	@GetMapping("/myCinema")
	public String getMyCinema(Model model, @RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		Page<Cinema> cinemas;
		
		List<Cinema> cinemas1 = cinemaService.readAllByPageAndKeyWord(keyWord, PageRequest.of(page, size)).getContent();
		List<City> city = cityService.readCityByName(keyWord);
		List<Cinema> cinemas2 = new ArrayList<Cinema>(cinemas1);
		if (!city.isEmpty()) {
			city.forEach(cit->{
				cinemas2.addAll(cit.getCinemas());
			});

		}
		
		Pageable pageable = PageRequest.of(page, size);
		final int start = (int) pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), cinemas2.size());
		cinemas = new PageImpl<>(cinemas2.subList(start, end), pageable, cinemas2.size());
	
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[cinemas.getTotalPages()]);
		model.addAttribute("totalPages", cinemas.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("cityName", "Toulouse");
		return "showCinemas";
	}
	
	@GetMapping("/myCinemaDisp")
	public String getMyCinemaDisp(Model model, @RequestParam(name = "keyWord", defaultValue = "") String keyWord,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {

		Page<Cinema> cinemas = cinemaService.readAllByPageAndKeyWord(keyWord, PageRequest.of(page, size));
		
	
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[cinemas.getTotalPages()]);
		model.addAttribute("totalPages", cinemas.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("cinemas", cinemas);
		model.addAttribute("cityName", "Toulouse");
		return "showCinemaDisp";
	}
	
	@GetMapping("/myCity")
	public String getMyCity(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "id", defaultValue = "") Long id, RedirectAttributes attributes) {
		if(id!=null) {
			attributes.addAttribute("keyWord", cityService.readCityById(id).getName());
			return "redirect:myCinema";
		}
		
		Page<City> cities = cityService.findByPageByPage(PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[cities.getTotalPages()]);
		model.addAttribute("totalPages", cities.getTotalPages());
		model.addAttribute("cities", cities.getContent());
		return "showCities";
	}


}
