package com.ashokit.ies.dc.service;

import java.util.List;

import com.ashokit.ies.dc.domain.DCChild;

public interface DCChildService {
	
	public boolean saveChild(DCChild dcChild);
	public List<DCChild> getAllChildrenByCaseId(String caseId);

}
