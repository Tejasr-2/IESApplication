package com.ashokit.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "DC_cases")
public class DCCaseEntity {
	@Id
	@GenericGenerator(name="CaseNumberGenerator", strategy = "com.ashokit.ies.dc.generators.CaseNumberGenerator")
	@GeneratedValue(generator="CaseNumberGenerator")
	private String caseNumber;
	private String applicationId;
	private String citizenName;
	private String dob;
	private String gender;
	private long phoneNumber;
	private String ssnNumber;
	private String email;


}
