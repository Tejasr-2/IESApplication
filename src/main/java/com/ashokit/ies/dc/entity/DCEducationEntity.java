package com.ashokit.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dc_education")
public class DCEducationEntity {
	
	@Id
	private String caseId;
	private String name;
	private String highestQualification;
	private String completedYear;
	private String grade;

}
