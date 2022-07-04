package com.fms.distopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
