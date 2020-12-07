package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.admin.service.PlansService;
import com.ashokit.ies.dc.domain.DCChild;
import com.ashokit.ies.dc.domain.DCEducation;
import com.ashokit.ies.dc.domain.DCIncome;
import com.ashokit.ies.dc.domain.DCPlan;
import com.ashokit.ies.dc.service.DCIncomeService;
import com.ashokit.ies.dc.service.DCPlanService;

@Controller
public class DCPlanController {

	@Autowired
	DCPlanService dcPlanservice;

	@Autowired
	PlansService planService;
	
	@Autowired
	DCIncomeService dcIncomeService;
	

	@PostMapping("/saveDCPlan")
	public String saveDCPlan(@ModelAttribute("dcPlan") DCPlan dcPlan, Model model) {
		dcPlanservice.saveDCPlan(dcPlan);
		
		if (dcPlan.getPlanName().equals("SNAP")) {
			DCIncome dcIncome = new DCIncome();
			dcIncome.setCaseId(dcPlan.getCaseId());
			dcIncome.setName(dcPlan.getFirstName() + " " + dcPlan.getLastName());
			model.addAttribute("dcIncome", dcIncome);
			return "IncomeDetails";
		}
		if (dcPlan.getPlanName().equals("CCAP")) {
			DCChild dcChild = new DCChild();
			dcChild.setCaseId(dcPlan.getCaseId());
			dcChild.setParentName(dcPlan.getFirstName() + " " + dcPlan.getLastName());
			model.addAttribute("dcChild", dcChild);
			return "ChildDetails";
		}
		if (dcPlan.getPlanName().equals("KTW")) {
			DCEducation dcEducation = new DCEducation();
			dcEducation.setName(dcPlan.getFirstName() + " " + dcPlan.getLastName());
			dcEducation.setCaseId(dcPlan.getCaseId());
			model.addAttribute("dcEducation", dcEducation);
			return "EducationalDetails";
		}
		
		
		return "IncomeDetails";
	}

	/*
	 * @PostMapping(value = "/saveDCPlan", consumes =
	 * MediaType.APPLICATION_FORM_URLENCODED_VALUE) public ResponseEntity<DCPlan>
	 * handleSaveButton(DCPlan globalPlan) {
	 * 
	 * dcPlanservice.saveDCPlan(globalPlan);
	 * 
	 * // red.addFlashAttribute("dcPlan",dcPlan); //
	 * model.addAttribute("dcPlan",dcPlan);
	 * 
	 * return new ResponseEntity<>(new DCPlan(), HttpStatus.CREATED); }
	 */

}
