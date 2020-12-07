package com.ashokit.ies.batches.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.batches.domain.BatchRunDetails;
import com.ashokit.ies.batches.entity.BatchRunDetailsEntity;
import com.ashokit.ies.batches.repository.BatchRunDetailsRepository;

@Service
public class BatchRunDetailsServiceIMPL implements BatchRunDetailsService{
	
	@Autowired
	BatchRunDetailsRepository batchRunDetailsRepo;

	@Override
	public BatchRunDetails save(BatchRunDetails batch) {
		BatchRunDetailsEntity entity = new BatchRunDetailsEntity();
		BeanUtils.copyProperties(batch, entity);
		BatchRunDetailsEntity savedEntity = batchRunDetailsRepo.save(entity);
		BeanUtils.copyProperties(savedEntity, batch);
		return null;
	}

}
