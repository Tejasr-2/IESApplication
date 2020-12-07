package com.ashokit.ies.batches;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashokit.ies.batches.domain.BatchRunDetails;
import com.ashokit.ies.batches.service.BatchRunDetailsService;
import com.ashokit.ies.co.domain.COTriggers;
import com.ashokit.ies.co.service.COTriggersService;

public class COGenDlyBatch {

	@Autowired
	BatchRunDetailsService batchRunDetailsService;

	@Autowired
	COTriggersService coTriggersService;

	public void prePoccess(String batchName) {
		BatchRunDetails batch = new BatchRunDetails();
		batch.setBatchName(batchName);
		batch.setBatchRunStatus("Starting");
		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		batch.setStartDate(new Date());
		start(batch);
	}

	public void start(BatchRunDetails batch) {

		batch.setBatchRunStatus("Started");
		List<COTriggers> triggers = coTriggersService.findByTriggerStatus("P");
		for (COTriggers trigger : triggers) {
			process(trigger);	
		}

	}

	public void process(COTriggers trigger) {

	}

	public void postProcess(BatchRunDetails batch) {
		
		batch.setBatchRunStatus("Ended");
		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		batch.setEndDate(new Date());

	}
}
