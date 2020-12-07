package com.ashokit.ies.batches.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "batch_run_dtls")
public class BatchRunDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int batchRunSeq;
	private String batchName;
	private String batchRunStatus;
	private Date endDate;
	private int instanceNum;
	private Date startDate;
}
