package com.ashokit.ies.co.service;

import java.util.List;

import com.ashokit.ies.co.domain.COTriggers;

public interface COTriggersService {
	
	public boolean save(COTriggers trigger);
	public List<COTriggers> findByTriggerStatus(String status);

}
