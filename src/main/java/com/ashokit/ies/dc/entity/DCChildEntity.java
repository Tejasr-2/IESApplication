package com.ashokit.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dc_childs")
public class DCChildEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long childId;
	private String caseId;
	private String parentName;
	private String childName;
	private String gender;
	private String dob;
	private String ssnNumber;
	

}
