package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.admin.domain.PlansDomain;
import com.ashokit.ies.admin.service.PlansService;

@Controller
public class RegisterPlanController {

	@Autowired
	PlansService planService;

	@GetMapping("/RegisterPlanPage")
	public String showRegistrationForm(Model model) {

		model.addAttribute("plan", new PlansDomain());

		return "PlanRegistration";
	}
	
	
	@PostMapping("/RegisterPlan")
	public String handleSubmitButton(@ModelAttribute("plan") PlansDomain plan,Model model) {
		
		if (planService.savePlan(plan))
			model.addAttribute("succMsg", "Plan Registered Successfully");
		else
			model.addAttribute("failMsg", "Unable to Register Plan");
		
		return "PlanRegistration";
	}
}
