package com.ashokit.ies.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.service.ApplicationService;

@Controller
public class ViewApplicationsController {

	@Autowired
	ApplicationService applicationService;

	@GetMapping("/ViewApplications")
	public String showApplications(Model model) {

		List<Application> allApplications = applicationService.getAllApplications();

		model.addAttribute("applications", allApplications);

		return "ViewApplications";
	}

	@GetMapping("/editApplication")
	public String handleEditApplication(@RequestParam("aid") String aid, Model model) {
		Application application = applicationService.getApplicationById(aid);

		model.addAttribute("application", application);

		return "ApplicationRegistration";
	}

	@GetMapping("/deleteApplication")
	public String handleDeleteApplication(@RequestParam("aid")String aid, Model model) {
		
		applicationService.deactivateApplication(aid);
		
		List<Application> allApplications = applicationService.getAllApplications();

		model.addAttribute("applications", allApplications);
		return "ViewApplications";
	}
	
	@GetMapping("/activateApplication")
	public String handleActivateApplication(@RequestParam("aid")String aid, Model model) {
		
		applicationService.activateApplication(aid);
		
		List<Application> allApplications = applicationService.getAllApplications();

		model.addAttribute("applications", allApplications);
		return "ViewApplications";
	}
	

}
