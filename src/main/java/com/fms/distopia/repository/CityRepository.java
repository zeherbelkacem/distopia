package com.fms.distopia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Cinema;
import com.fms.distopia.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	/**
	 * 
	 * @param keyWord
	 * @return
	 */
	List<City> findByNameContains(String keyWord);

	/**
	 * 
	 * @param cityName
	 * @return
	 */
	City findByName(String cityName);

}
