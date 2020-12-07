package com.ashokit.ies.ed.domain;

import java.util.Date;

import lombok.Data;

@Data
public class EligibilityDetails {
	
	private int edTraceId;
	private String benefitAmount;
	private int caseNum;
	private Date createDate;
	private String denialReason;
	private Date planEndDate;
	private String planName;
	private String planStartDate;
	private String planStatus;
	private Date updateDate;

}
