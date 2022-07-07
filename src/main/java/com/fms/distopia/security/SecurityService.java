package com.fms.distopia.security;


public interface SecurityService {

	/**
	 * 
	 * @param username
	 * @return
	 */
	public Uuser findUuserByUserName(String username);

	public Uuser saveUuser(Uuser user);

	public Role getRoleByRoleName(String string);
}
