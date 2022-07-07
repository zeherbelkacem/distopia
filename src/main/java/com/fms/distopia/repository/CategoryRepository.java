package com.fms.distopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
	
//	@Transactional
//	@Modifying
//	@Query("UPDATE categories c SET c.name=:newName WHERE c.name=:oldName")
//	void updateCategory(@Param("oldName") String oldName, @Param("newName") String newName);
}
