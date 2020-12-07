package com.ashokit.ies.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.ashokit.ies.ar.domain.Application;
import com.ashokit.ies.ar.domain.CitizenInfo;
import com.ashokit.ies.ar.service.ApplicationService;

@Controller
public class ApplicationRegistrationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/ApplicationRegistrationForm")
	public String loadApplicationRegistrationForm(Model model) {
		
		model.addAttribute("application",new Application());
		return "ApplicationRegistration";
	}
	
	@PostMapping("/RegisterApplication")
	public String handleRegisterButton(@ModelAttribute("application")Application application, Model model ) {
		
		String ssnNumber = application.getSsnNumber();
		String endPointUrl = "http://localhost:8090/SSN/citizens/" + ssnNumber;
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<CitizenInfo> forEntity = rt.getForEntity(endPointUrl, com.ashokit.ies.ar.domain.CitizenInfo.class);
		int statusCodeValue = forEntity.getStatusCodeValue();
		
		if(statusCodeValue == 201 )
		{
			CitizenInfo body = forEntity.getBody(); 
			if (body.getStateName().equals("KT"))
			{
				String applicationId = applicationService.saveApplication(application);
				model.addAttribute("succMsg", "Created Application with Id : " + applicationId);
			}
			else {
				model.addAttribute("failMsg", "Citizen Does Not Reside in Kentucky, Please Contact "+ body.getStateName() + " DHO");
			}
			
		}
		if(statusCodeValue == 400 ) {
			model.addAttribute("failMsg", "Please Check The SSN Entered");
		}
	
			
	
			
		
		model.addAttribute("application",new Application());
		
		return "ApplicationRegistration";
	}
	

}
