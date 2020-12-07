package com.ashokit.ies.co.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "co_triggers")
public class COTriggersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trgId;
	private int caseNUm;
	private Date createDate;
	private String trgStatus;
	private Date updateDate;

}
