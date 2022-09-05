package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.City;

public interface ICityService {

	/**
	 * 
	 * @param keyWord
	 * @return
	 */
	List<City> readCityByName(String keyWord);

	/**
	 * 
	 * @param id
	 */
	public void deleteCityById(Long id);

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<City> findByPageByPage(Pageable pageable);

	/**
	 * 
	 * @return
	 */
	public List<City> readAllCities();

	/**
	 * 
	 * @param cityName
	 * @return
	 */
	public City getCityByName(String cityName);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public City readCityById(Long id);

	/**
	 * 
	 * @param city
	 * @return
	 */
	public City saveCity(@Valid City city);

}
