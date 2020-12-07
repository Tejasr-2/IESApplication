package com.ashokit.ies.dc.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.ies.admin.service.PlansService;
import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.service.ApplicationService;
import com.ashokit.ies.dc.domain.DCCase;
import com.ashokit.ies.dc.domain.DCPlan;
import com.ashokit.ies.dc.service.DCCaseService;

@Controller
public class CreateCaseController {

	@Autowired
	DCCaseService caseService;
	
	@Autowired
	ApplicationService appService;
	
	@Autowired
	PlansService planService;

	@GetMapping("/CreateCase")
	public String showForm(Model model) {

		DCCase newCase = new DCCase();
		model.addAttribute("case", newCase);

		return "CreateCase";
	}

	@GetMapping("/checkApplicationNumber")
	public @ResponseBody Application checkApplicationNumber(@RequestParam("applicationNumber") String appNumber) {

		return caseService.verifyApplication(appNumber);

	}

	// @PostMapping(value = "/createCase", consumes =
	// MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	/*
	 * @PostMapping(value = "/createCase") public String
	 * handleSaveButton(@RequestBody Case newCase,RedirectAttributes red) {
	 * 
	 * Case savedCase = caseService.saveCase(newCase);
	 * System.out.println("Case Saved"); DCPlan dcPlan = new DCPlan();
	 * dcPlan.setCaseId(savedCase.getCaseNumber()); String name =
	 * savedCase.getCitizenName(); String[] splitedName = name.split("\\s+");
	 * dcPlan.setFirstName(splitedName[0]); dcPlan.setLastName(splitedName[1]);
	 * 
	 * //red.addFlashAttribute("dcPlan",dcPlan);
	 * //model.addAttribute("dcPlan",dcPlan);
	 * 
	 * return "redirect:/PlanSelectionPage"; }
	 */

	/*
	 * @PostMapping(value = "/createCase", consumes =
	 * MediaType.APPLICATION_FORM_URLENCODED_VALUE) public ResponseEntity<DCPlan>
	 * handleSaveButton(DCCase globalCase) {
	 * 
	 * DCCase savedCase = caseService.saveCase(globalCase);
	 * System.out.println("Case Saved"); DCPlan dcPlan = new DCPlan();
	 * dcPlan.setCaseId(savedCase.getCaseNumber()); String name =
	 * savedCase.getCitizenName(); String[] splitedName = name.split("\\s+");
	 * dcPlan.setFirstName(splitedName[0]); dcPlan.setLastName(splitedName[1]);
	 * 
	 * //red.addFlashAttribute("dcPlan",dcPlan);
	 * //model.addAttribute("dcPlan",dcPlan);
	 * 
	 * return new ResponseEntity<>(dcPlan,HttpStatus.CREATED); }
	 */

	@GetMapping("/PlanSelection")
	public String handleCreateCase(@RequestParam("applicationId") String appId,Model model)	{
		
		DCCase newCase = new DCCase();
		Application applicationById = appService.getApplicationById(appId);
		newCase.setApplicationId(appId);
		newCase.setCitizenName(applicationById.getFirstName() +" "+ applicationById.getLastName());
		newCase.setDob(applicationById.getDob());
		newCase.setSsnNumber(applicationById.getSsnNumber());
		newCase.setGender(applicationById.getGender());
		newCase.setPhoneNumber(applicationById.getPhoneNumber());
		newCase.setEmail(applicationById.getEmail());
		DCCase saveCase = caseService.saveCase(newCase);
		
		System.out.println("Case Created");
		System.out.println(saveCase);
		DCPlan dcPlan = new DCPlan();
		dcPlan.setCaseId(saveCase.getCaseNumber());
		String[] name = saveCase.getCitizenName().split("\\s+");
		dcPlan.setFirstName(name[0]);
		dcPlan.setLastName(name[1]);
		
		model.addAttribute("dcPlan", dcPlan);
		ArrayList<String> activePlans = planService.getActivePlans();
		model.addAttribute("plans",activePlans);
		
		return "PlanSelectionPage";
	}

}
