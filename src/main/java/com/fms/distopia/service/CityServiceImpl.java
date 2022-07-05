package com.fms.distopia.service;

import org.springframework.stereotype.Service;

import com.fms.distopia.repository.CityRepository;

@Service
public class CityServiceImpl implements ICityService{

	private CityRepository cityRepository;

	public CityServiceImpl(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
}
