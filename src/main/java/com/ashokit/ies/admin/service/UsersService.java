package com.ashokit.ies.admin.service;

import java.util.List;

import com.ashokit.ies.admin.domain.UsersDomain;

public interface UsersService {
	
	
	public boolean saveUser(UsersDomain user);
	public List<UsersDomain> getAllUsersByRole(String role);
	public String isUniqueEmail(String email);
	public UsersDomain findByUid(int uid);
	public List<UsersDomain> getAllUsers();
	public void deactivateUser(int uid);
	public void activateUser(int uid);
	

}
