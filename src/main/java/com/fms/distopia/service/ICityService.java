package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fms.distopia.entities.City;

public interface ICityService {

	List<City> readCityByName(String keyWord);

	public void deleteCityById(Long id);

	public Page<City> findByPageByPage(Pageable pageable);

	public List<City> readAllCities();

	public City getCityByName(String cityName);

	public City readCityById(Long id);

	public City saveCity(@Valid City city);

}
