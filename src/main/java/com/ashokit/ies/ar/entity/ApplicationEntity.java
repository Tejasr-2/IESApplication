package com.ashokit.ies.ar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "Applications")
public class ApplicationEntity {
	
	@Id
	@GenericGenerator(name="appNumberGenerator", strategy = "com.ashokit.ies.ar.generators.ApplicationNumberGenerator")
	@GeneratedValue(generator="appNumberGenerator")
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
