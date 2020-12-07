package com.ashokit.ies.batches.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BatchRunDetails {
	
	private int batchRunSeq;
	private String batchName;
	private String batchRunStatus;
	private Date endDate;
	private int instanceNum;
	private Date startDate;
	

}
