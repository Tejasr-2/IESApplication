package com.ashokit.ies.dc.domain;

import lombok.Data;

@Data
public class DCChild {
	
	private long childId;
	private String caseId;
	private String parentName;
	private String childName;
	private String gender;
	private String dob;
	private String ssnNumber;

}
