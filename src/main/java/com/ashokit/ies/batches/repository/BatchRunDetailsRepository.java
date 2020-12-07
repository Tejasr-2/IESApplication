package com.ashokit.ies.batches.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.batches.entity.BatchRunDetailsEntity;

public interface BatchRunDetailsRepository extends JpaRepository<BatchRunDetailsEntity, Serializable> {

}
