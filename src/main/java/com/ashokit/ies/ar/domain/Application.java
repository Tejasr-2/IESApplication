package com.ashokit.ies.ar.domain;

import lombok.Data;

@Data
public class Application {

	private String applicationId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String ssnNumber;
	private long phoneNumber;
	private String email;
	private String applicationStatus;
	
}
