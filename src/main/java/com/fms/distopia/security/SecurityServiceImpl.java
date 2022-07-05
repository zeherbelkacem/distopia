package com.fms.distopia.security;

import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{

	
	private UuserRepository uuserRepository;
	private RoleRepository roleRepository;
	
	/**
	 * Dependencies injection
	 * @param uuserRepository
	 * @param roleRepository
	 */
	public SecurityServiceImpl(UuserRepository uuserRepository, RoleRepository roleRepository) {
		this.uuserRepository = uuserRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public Uuser findUuserByUserName(String username) {
		return uuserRepository.findByUserName(username);
	}
	
	
}
