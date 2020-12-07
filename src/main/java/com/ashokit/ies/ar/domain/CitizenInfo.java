package com.ashokit.ies.ar.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CitizenInfo {
	
	private String ssn;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String stateName;
	private byte[] photo;

}
