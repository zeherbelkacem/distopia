package com.fms.distopia.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.distopia.entities.Cinema;
import com.fms.distopia.entities.City;
import com.fms.distopia.repository.CityRepository;

@Service
public class CityServiceImpl implements ICityService{

	private CityRepository cityRepository;

	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> readCityByName(String keyWord) {
		return cityRepository.findByNameContains(keyWord);
	}

	@Override
	public void deleteCityById(Long id) {
		cityRepository.deleteById(id);
	}

	@Override
	public Page<City> findByPageByPage(Pageable pageable) {
		return cityRepository.findAll(pageable);
	}

	@Override
	public List<City> readAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City getCityByName(String cityName) {
		return cityRepository.findByName(cityName);
	}

	@Override
	public City readCityById(Long id) {
		return cityRepository.findById(id).get();
	}

	@Override
	public City saveCity(@Valid City city) {
		return cityRepository.save(city);
	}
	
}
