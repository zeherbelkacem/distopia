package com.fms.distopia.security;

import org.springframework.stereotype.Controller;

@Controller
public class SecurityController {

	private UuserRepository uuserRepository;
	private RoleRepository roleRepository;
	
	/**
	 * Dependencies injection
	 * @param uuserRepository
	 * @param roleRepository
	 */
	public SecurityController(UuserRepository uuserRepository, RoleRepository roleRepository) {
		this.uuserRepository = uuserRepository;
		this.roleRepository = roleRepository;
	}
}
