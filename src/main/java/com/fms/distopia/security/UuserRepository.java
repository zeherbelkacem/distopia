package com.fms.distopia.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UuserRepository extends JpaRepository<Uuser, Long> {

	/**
	 * 
	 * @param username
	 * @return
	 */
	public Uuser findByUserName(String username);

}
