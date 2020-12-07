package com.ashokit.ies.co.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.co.entity.COTriggersEntity;

public interface COTriggersRepository extends JpaRepository<COTriggersEntity, Serializable> {
	
	public List<COTriggersEntity> findByTrgStatus(String status);

}
