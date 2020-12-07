package com.ashokit.ies.admin.domain;

import lombok.Data;

@Data
public class PlansDomain {
	
	
	private int planId;
	private String planName;
	private String planDescription;
	private String planStatus;
	private String startDate;
	private String endDate;

}
