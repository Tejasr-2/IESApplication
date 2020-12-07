package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.dc.domain.DCEducation;
import com.ashokit.ies.dc.service.DCEducationService;

@Controller
public class DCEducationController {

	@Autowired
	DCEducationService dcEducationService;
	
	@PostMapping("/saveEducationDetails")
	public String saveEducationDetails(@ModelAttribute("dcEducation")DCEducation dcEducation) {
		dcEducationService.save(dcEducation);
		
		
		return "EligibilityDetermination";
	}
}
