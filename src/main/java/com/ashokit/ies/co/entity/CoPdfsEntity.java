package com.ashokit.ies.co.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "co_pdfs")
public class CoPdfsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int coPdfId;
	private String planStatus;
	private String caseNumber;
	private byte[] pdfDocument;
	private String planName;
	

}
