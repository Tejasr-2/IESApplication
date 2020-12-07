package com.ashokit.ies.ar.service;

import java.util.List;

import com.ashokit.ies.ar.domain.Application;

public interface ApplicationService {
	
	public String saveApplication(Application application );
	public String chekcState(Application application);
	public List<Application> getAllApplications();
	public Application getApplicationById(String aid);
	public void deactivateApplication(String aid);
	public void activateApplication(String aid);
	
}
