package com.ashokit.ies.dc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.ies.dc.domain.DCIncome;
import com.ashokit.ies.dc.entity.DCIncomeEntity;
import com.ashokit.ies.dc.repository.DCIncomeRepository;

@Service
public class DCINcomeServiceIMPL implements DCIncomeService {

	@Autowired
	DCIncomeRepository dcIncomeRepo;
	
	@Override
	public boolean saveDcIncome(DCIncome dcIncome) {
		DCIncomeEntity entity = new DCIncomeEntity();
		BeanUtils.copyProperties(dcIncome, entity);		
		dcIncomeRepo.save(entity);
		return dcIncomeRepo.save(entity)!=null;
	}

}
