package com.ashokit.ies.dc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.dc.domain.DCChild;
import com.ashokit.ies.dc.entity.DCChildEntity;
import com.ashokit.ies.dc.repository.DCChildRepository;

@Service
public class DCChildServiceIMPL implements DCChildService {

	@Autowired
	DCChildRepository dcChildRepo;

	@Override
	public boolean saveChild(DCChild dcChild) {
		DCChildEntity entity = new DCChildEntity();
		BeanUtils.copyProperties(dcChild, entity);
		DCChildEntity saveedEntity = dcChildRepo.save(entity);
		return saveedEntity != null;
	}

	@Override
	public List<DCChild> getAllChildrenByCaseId(String caseId) {

		List<DCChildEntity> allChildrenByCaseId = dcChildRepo.findAllByCaseId(caseId);

		List<DCChild> allChildren = new ArrayList<>();
		
		for (DCChildEntity entity : allChildrenByCaseId) {
			DCChild tmpChild = new DCChild();
			BeanUtils.copyProperties(entity, tmpChild);
			allChildren.add(tmpChild);			
		}

		return allChildren;
	}

}
