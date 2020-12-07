package com.ashokit.ies.co.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.co.domain.COTriggers;
import com.ashokit.ies.co.entity.COTriggersEntity;
import com.ashokit.ies.co.repository.COTriggersRepository;

@Service
public class COTriggersServiceIMPL implements COTriggersService {

	@Autowired
	COTriggersRepository coTriggerRepo;

	@Override
	public boolean save(COTriggers trigger) {
		COTriggersEntity entity = new COTriggersEntity();
		BeanUtils.copyProperties(trigger, entity);
		coTriggerRepo.save(entity);
		return coTriggerRepo.save(entity) != null;
	}

	@Override
	public List<COTriggers> findByTrigger(String status) {

		List<COTriggersEntity> entities = coTriggerRepo.findByTrgStatus(status);

		List<COTriggers> triggers = new ArrayList<COTriggers>();
		for (COTriggersEntity entity : entities) {
			COTriggers tmpTrig = new COTriggers();
			BeanUtils.copyProperties(entity, tmpTrig);
			triggers.add(tmpTrig);
		}

		return triggers;
	}

}
