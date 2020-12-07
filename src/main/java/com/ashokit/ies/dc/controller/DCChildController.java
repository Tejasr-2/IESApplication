package com.ashokit.ies.dc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.dc.domain.DCChild;
import com.ashokit.ies.dc.service.DCChildService;

@Controller
public class DCChildController {

	@Autowired
	DCChildService dcChildservice;

	@PostMapping("/addChild")
	public String addChild(@ModelAttribute("dcChild") DCChild dcChild, Model model) {
		dcChildservice.saveChild(dcChild);
		DCChild child = new DCChild();
		child.setCaseId(dcChild.getCaseId());
		child.setParentName(dcChild.getParentName());
		model.addAttribute("dcChild", child);

		List<DCChild> allChildrenByCaseId = dcChildservice.getAllChildrenByCaseId(dcChild.getCaseId());
		model.addAttribute("children", allChildrenByCaseId);

		return "ChildDetails";
	}

	@GetMapping("/Eligibility")
	public String handleNextButton() {
		return "EligibilityDetermination";
	}

}
