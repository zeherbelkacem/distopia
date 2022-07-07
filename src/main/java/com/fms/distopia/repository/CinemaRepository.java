package com.fms.distopia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	Page<Cinema> findByNameContains(String keyWord, Pageable pageable);

}
