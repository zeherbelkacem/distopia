package com.fms.distopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
