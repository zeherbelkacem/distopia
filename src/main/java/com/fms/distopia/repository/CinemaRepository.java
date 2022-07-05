package com.fms.distopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
