package com.fms.distopia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.distopia.entities.Category;
import com.fms.distopia.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
