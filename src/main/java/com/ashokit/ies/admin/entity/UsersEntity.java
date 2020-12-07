package com.ashokit.ies.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Accounts")
public class UsersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String pazzword;
	private String dob;
	private String gender;
	private long ssnNumber;
	private long phoneNUmber;
	private String role;
	private String accStatus;
	
}
