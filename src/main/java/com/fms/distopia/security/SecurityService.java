package com.fms.distopia.security;


public interface SecurityService {

	/**
	 * 
	 * @param username
	 * @return
	 */
	public Uuser findUuserByUserName(String username);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public Uuser saveUuser(Uuser user);

	/**
	 * 
	 * @param string
	 * @return
	 */
	public Role getRoleByRoleName(String string);
}
