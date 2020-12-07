package com.ashokit.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.ies.admin.domain.PlansDomain;
import com.ashokit.ies.admin.service.PlansService;

@Controller
public class ViewPlansController {

	@Autowired
	PlansService planService;

	@GetMapping("/ViewPlans")
	public String showViewPlansForm(Model model) {

		List<PlansDomain> plans = planService.getAllPlans();

		model.addAttribute("plans", plans);

		return "ViewPlans";
	}

	@GetMapping("/editPlan")
	public String editUser(@RequestParam("pid") int pid, Model model) {

		PlansDomain plan = planService.findByPlanId(pid);
		
		model.addAttribute("plan", plan);

		return "PlanRegistration";
	}

	@GetMapping("/deletePlan")
	public String deleteUser(@RequestParam("pid") int pid, Model model) {
		
		planService.deactivatePlan(pid);
		
		List<PlansDomain> plans = planService.getAllPlans();

		model.addAttribute("plans", plans);
		
		return "ViewPlans";
	}
	
	@GetMapping("/activatePlan")
	public String activatePlan(@RequestParam("pid") int pid, Model model) {
       planService.activatePlan(pid);
		
		List<PlansDomain> plans = planService.getAllPlans();

		model.addAttribute("plans", plans);
		
		return "ViewPlans";
		
	}
	

	
	
}
