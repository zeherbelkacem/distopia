package com.fms.distopia.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	/**
	 * 
	 * @param role
	 * @return
	 */
	public Role findByRole(String role);

}
