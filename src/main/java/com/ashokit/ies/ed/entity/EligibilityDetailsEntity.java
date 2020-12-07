package com.ashokit.ies.ed.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "eligibility_details")
public class EligibilityDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
