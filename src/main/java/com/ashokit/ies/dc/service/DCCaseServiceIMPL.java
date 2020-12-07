package com.ashokit.ies.dc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.entity.ApplicationEntity;
import com.ashokit.ies.ar.repository.ApplicationRepository;
import com.ashokit.ies.dc.domain.DCCase;
import com.ashokit.ies.dc.entity.DCCaseEntity;
import com.ashokit.ies.dc.repository.DCCaseRepository;

@Service
public class DCCaseServiceIMPL implements DCCaseService {

	@Autowired
	DCCaseRepository caseRepo;
	
	@Autowired
	ApplicationRepository appRepo;

	@Override
	public DCCase saveCase(DCCase citizenCase) {
		DCCaseEntity caseEntity = new DCCaseEntity();
		BeanUtils.copyProperties(citizenCase, caseEntity);
		DCCaseEntity savedEntity = caseRepo.save(caseEntity);
		
		BeanUtils.copyProperties(savedEntity, citizenCase);

		return citizenCase;
	}

	@Override
	public List<DCCase> getAllCases() {
		List<DCCaseEntity> findAll = caseRepo.findAll();
		List<DCCase> allCases = new ArrayList<DCCase>();

		for (DCCaseEntity entity : findAll) {
			DCCase tmpCase = new DCCase();
			BeanUtils.copyProperties(entity, tmpCase);
			allCases.add(tmpCase);
		}

		return allCases;
	}

	@Override
	public Application verifyApplication(String applicationNumber) {
		Optional<ApplicationEntity> findById = appRepo.findById(applicationNumber);
		if(findById.isPresent()) {
		ApplicationEntity applicationEntity = findById.get();
		Application app = new Application();
		BeanUtils.copyProperties(applicationEntity, app);
		return app;
		}
		return new Application();
		
	}

}
