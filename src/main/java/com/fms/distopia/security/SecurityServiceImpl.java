package com.fms.distopia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class SecurityServiceImpl implements SecurityService{

	
	@Autowired
	private UuserRepository uuserRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
	@Override
	public Uuser saveUuser(Uuser user) {
		
		//Creation
		if(uuserRepository.findById(user.getUserId()).isEmpty()) {
//			if (uuserRepository.findByUserName(user.getUserName()) != null) {
//				throw new NotFoundEntityException("User with the sme userName exists");
//			}
			String pwdEncoder = passwordEncoder.encode(user.getPassword());
			user.setPassword(pwdEncoder);
			return uuserRepository.save(user);
		}
		//Updating
		return uuserRepository.save(user);
	}
	
	@Override
	public Role getRoleByRoleName(String roleName) {
		return roleRepository.findByRole(roleName);
	}

	
}
