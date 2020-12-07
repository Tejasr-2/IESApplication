package com.ashokit.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dc_plans")
public class DCPlanEntity {
	
	@Id
	private String caseId;
	private String firstName;
	private String lastName;
	private String planName;

}
