package com.ashokit.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.dc.entity.DCCaseEntity;

public interface DCCaseRepository extends JpaRepository<DCCaseEntity, Serializable>{

}
