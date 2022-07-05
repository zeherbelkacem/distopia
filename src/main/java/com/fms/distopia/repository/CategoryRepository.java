package com.fms.distopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
