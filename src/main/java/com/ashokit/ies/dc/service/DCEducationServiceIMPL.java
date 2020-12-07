package com.ashokit.ies.dc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.dc.domain.DCEducation;
import com.ashokit.ies.dc.entity.DCEducationEntity;
import com.ashokit.ies.dc.repository.DCEducationRepository;

@Service
public class DCEducationServiceIMPL implements DCEducationService {
	
	@Autowired
	DCEducationRepository dcEducationRepo;

	@Override
	public boolean save(DCEducation dcEducation) {
		
		DCEducationEntity entity = new DCEducationEntity();
		BeanUtils.copyProperties(dcEducation, entity);
		DCEducationEntity savedEntity = dcEducationRepo.save(entity);
	
		return savedEntity!=null;
	}

}
