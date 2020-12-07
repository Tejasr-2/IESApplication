package com.ashokit.ies.admin.service;

import java.util.ArrayList;
import java.util.List;

import com.ashokit.ies.admin.domain.PlansDomain;

public interface PlansService {
	
	public boolean savePlan(PlansDomain plan);
	public List<PlansDomain> getAllPlans();
	public PlansDomain findByPlanId(int pid);
	public void deactivatePlan(int pid);
	public void activatePlan(int pid);
	public ArrayList<String> getActivePlans();

}
