package com.ashokit.ies.dc.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.dc.entity.DCChildEntity;

public interface DCChildRepository extends JpaRepository<DCChildEntity, Serializable>{
	
	public List<DCChildEntity> findAllByCaseId(String caseId);

}
