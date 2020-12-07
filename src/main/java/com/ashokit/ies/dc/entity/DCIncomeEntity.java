package com.ashokit.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="dc_income")
public class DCIncomeEntity {

	@Id
	private String caseId;
	private String name;
	private String workStatus;
	private Integer otherIncome;
}
