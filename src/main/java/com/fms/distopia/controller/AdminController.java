package com.fms.distopia.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fms.distopia.entities.Address;
import com.fms.distopia.entities.Category;
import com.fms.distopia.entities.Cinema;
import com.fms.distopia.entities.City;
import com.fms.distopia.entities.Movie;
import com.fms.distopia.service.ICategoryService;
import com.fms.distopia.service.ICinemaService;
import com.fms.distopia.service.ICityService;
import com.fms.distopia.service.IMovieService;

/**
 * 
 * @author Stagiaires11P
 *
 */

@Controller
public class AdminController {

	@Autowired
	private ICityService cityService;
	@Autowired
	private ICinemaService cinemaService;
	@Autowired
	private IMovieService movieService;
	@Autowired
	private ICategoryService categoryService;

	/**
	 * 
	 * @param model
	 * @param page
	 * @param size
	 * @param id
	 * @return
	 */
	@GetMapping("admin")
	public String citiesList(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "id", defaultValue = "") Long id) {

		if (id != null)
			cityService.deleteCityById(id);

		Page<City> cities = cityService.findByPageByPage(PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[cities.getTotalPages()]);
		model.addAttribute("totalPages", cities.getTotalPages());
		model.addAttribute("cities", cities.getContent());
		return "admin";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param page
	 * @param size
	 * @param keyWord
	 * @return
	 */
	@RequestMapping("/cinemas")
	public String adminCinemas(Model model, @RequestParam(name = "id", defaultValue = "") Long id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord) {
		if (id != null)
			cinemaService.deleteCategory(id);
		Page<Cinema> cinemas = cinemaService.readAllByPageAndKeyWord(keyWord, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[cinemas.getTotalPages()]);
		model.addAttribute("totalPages", cinemas.getTotalPages());
		model.addAttribute("cinemas", cinemas.getContent());
		return "cinemas";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/classification")
	public String classification(Model model, @RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {
		if (!name.equals(""))
			categoryService.deleteCategory(name);
		Page<Category> categories = categoryService.readAllByPageAndKeyWord(PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[categories.getTotalPages()]);
		model.addAttribute("totalPages", categories.getTotalPages());
		model.addAttribute("categories", categories.getContent());
		return "categories";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/saveCinemaForm")
	public String saveCinemaForm(Model model) {

		List<String> moviesTitles = new ArrayList<String>();
		movieService.readAllMovies().forEach(m -> {
			moviesTitles.add(m.getTitle());
		});
		model.addAttribute("cities", cityService.readAllCities());
		model.addAttribute("cinema", new Cinema());
		model.addAttribute("address", new Address());
		model.addAttribute("moviesTitles", moviesTitles);
		return "saveNewCinema";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/updateCinemaForm")
	public String updateCinemaForm(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {
		List<String> citiesNames = new ArrayList<String>();
		for (City c : cityService.readAllCities()) {
			citiesNames.add(c.getName());
		}
		model.addAttribute("citiesNames", citiesNames);
		model.addAttribute("cities", cityService.readAllCities());
		model.addAttribute("cinema", cinemaService.getCinemaById(id));
		model.addAttribute("address", cinemaService.getCinemaById(id).getAddress());
		return "saveNewCinema";
	}

	/**
	 * 
	 * @param cinema
	 * @param address
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @param cityName
	 * @return
	 */
	@PostMapping("saveCinema")
	public String saveCinema(@Valid Cinema cinema, @Valid Address address, Model model, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, @RequestParam("cityName") String cityName,
			@RequestParam(value = "movieTitleArray", required = false) String[] movieTitleArray) {

		if (bindingResult.hasErrors()) {
			if (cinema.getId() != null) {
				redirectAttributes.addAttribute("id", cinema.getId());
				return "redirect:/updateCinemaForm";
			} else
				return "redirect:/saveCinemaForm";
		}
		if (movieTitleArray.length != 0) {
			for (int i = 0; i < movieTitleArray.length; i++) {
				cinema.getMovies().add(movieService.readMovieByTitle(movieTitleArray[i]));
			}

		}
		cinema.setCity(cityService.getCityByName(cityName));
		cinema.setAddress(address);
		cinemaService.saveCinema(cinema);
		return "redirect:/cinemas";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("admin/saveCityForm")
	public String saveCityForm(Model model) {
		model.addAttribute("city", new City());
//		model.addAttribute("cinemas", cinemaService.readAll());
		return "saveNewCity";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("admin/updateCityForm")
	public String updateCityForm(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {

		model.addAttribute("city", cityService.readCityById(id));
		return "saveNewCity";
	}

	/**
	 * 
	 * @param city
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("admin/saveCity")
	public String saveCity(@Valid City city, Model model, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			System.out.println(city.getId());
			if (city.getId() != null) {
				redirectAttributes.addAttribute("id", city.getId());
				return "redirect:/updateCityForm";
			} else
				return "redirect:/saveCityForm";
		}
		cityService.saveCity(city);
		return "redirect:/admin";
	}

	/**
	 * 
	 * @param model
	 * @param id
	 * @param page
	 * @param size
	 * @param keyWord
	 * @return
	 */
	@RequestMapping("/movies")
	public String adminMovies(Model model, @RequestParam(name = "id", defaultValue = "") Long id,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size,
			@RequestParam(name = "keyWord", defaultValue = "") String keyWord) {
		if (id != null)
			movieService.deleteMovieById(id);
		Page<Movie> movies = movieService.findByPagesAndByTitleAndClassification(keyWord, PageRequest.of(page, size));
		model.addAttribute("currentPage", page);
		model.addAttribute("size", size);
		model.addAttribute("pages", new int[movies.getTotalPages()]);
		model.addAttribute("totalPages", movies.getTotalPages());
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("movies", movies.getContent());
		return "movies";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/saveCategoryForm")
	public String saveCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "saveNewCategory";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("updateCategoryForm")
	public String updateCategoryForm(@RequestParam(name = "name") String name, Model model) {

		model.addAttribute("category", categoryService.readByName(name));
		return "saveNewCategory";
	}

	/**
	 * 
	 * @param city
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("saveCategory")
	public String saveCategory(@Valid Category category, Model model, BindingResult bindingResult,
			@RequestParam(name = "nameToUpdate") String nameToUpdate, RedirectAttributes redirectAttributes) {
		System.out.println(nameToUpdate);
		if (bindingResult.hasErrors()) {
			System.out.println(category.getName());
			if (category.getName() != null) {
				redirectAttributes.addAttribute("name", category.getName());
				return "redirect:/updateCategoryForm";
			} else
				return "redirect:/saveCategoryForm";
		}
		categoryService.deleteCategory(nameToUpdate);
		categoryService.saveCategory(category);
		return "redirect:/classification";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/saveMovieForm")
	public String saveMovieForm(Model model) {
		model.addAttribute("categories", categoryService.readAllCategories());
		model.addAttribute("movie", new Movie());
		return "saveNewMovie";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/updateMovieForm")
	public String updateMovieForm(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {
		List<String> categoriesNames = new ArrayList<String>();
		for (Category c : categoryService.readAllCategories()) {
			categoriesNames.add(c.getName());
		}

		model.addAttribute("categoriesNames", categoriesNames);
		model.addAttribute("categories", categoryService.readAllCategories());
		model.addAttribute("movie", movieService.readMovieById(id));
		return "saveNewMovie";
	}

	/**
	 * 
	 * @param movie
	 * @param model
	 * @param bindingResult
	 * @param redirectAttributes
	 * @param catName
	 * @param fileName
	 * @param duration
	 * @return
	 */
	@PostMapping("saveMovie")
	public String saveMovie(@Valid Movie movie, Model model, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, @RequestParam("catName") String catName,
			@RequestParam("fileName") String fileName, @RequestParam("duration") String duration) {

		if (bindingResult.hasErrors()) {
			if (movie.getId() != null) {
				redirectAttributes.addAttribute("id", movie.getId());
				return "redirect:/updateMovieForm";
			} else
				return "redirect:/saveMovieForm";
		}
		movie.setCategory(categoryService.readByName(catName));
		movie.setImage("img/" + fileName);
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}

}
