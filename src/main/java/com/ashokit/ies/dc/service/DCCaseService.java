package com.ashokit.ies.dc.service;

import java.util.List;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.dc.domain.DCCase;

public interface DCCaseService {
	
	public DCCase saveCase(DCCase citizenCase);
	public List<DCCase> getAllCases();
	public Application verifyApplication(String applicationNumber);

}
