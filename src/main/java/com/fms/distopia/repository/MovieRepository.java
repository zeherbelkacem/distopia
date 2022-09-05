package com.fms.distopia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	/**
	 * 
	 * @param keyWord
	 * @param pageable
	 * @return
	 */
	@Query(value = "select * from movie m where m.title like %:keyword% or m.category_name like %:keyword%", nativeQuery = true)
	Page<Movie> findByTitleContainsOrCategoryNameContains(@Param("keyword") String keyWord, Pageable pageable);

	/**
	 * 
	 * @param string
	 * @return
	 */
	public Movie findByTitle(String string);

}
