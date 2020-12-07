package com.ashokit.ies.dc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EligibilityDereminationController {

	@GetMapping("/DetermineEligibility")
	public String determineEligibility(@RequestParam("caseId")String caseId,Model model) {
		
		model.addAttribute("caseId",caseId);
		
		return "EligibilityResult";
	}
}
