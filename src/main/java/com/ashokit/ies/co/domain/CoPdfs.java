package com.ashokit.ies.co.domain;

import lombok.Data;

@Data
public class CoPdfs {

	private int coPdfId;
	private String planStatus;
	private String caseNumber;
	private byte[] pdfDocument;
	private String planName;
	
	
}
