package com.ashokit.ies.dc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.dc.domain.DCPlan;
import com.ashokit.ies.dc.entity.DCPlanEntity;
import com.ashokit.ies.dc.repository.DCPlanRepository;

@Service
public class DCPlanServiceIMPL implements DCPlanService {

	@Autowired
	DCPlanRepository dcPlanRepo;
	
	@Override
	public boolean saveDCPlan(DCPlan dcPlan) {
		DCPlanEntity entity = new DCPlanEntity();
		BeanUtils.copyProperties(dcPlan, entity);
		DCPlanEntity savedEntity = dcPlanRepo.save(entity);
		return savedEntity!=null;
	}

}
