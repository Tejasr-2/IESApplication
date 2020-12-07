package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.ies.dc.domain.DCIncome;
import com.ashokit.ies.dc.service.DCIncomeService;

@Controller
public class DCIncomeController {
	
	@Autowired
	DCIncomeService dcIncomeService;

	@PostMapping("caseIncomeDetails")
	public String handleSubmitIncome(@ModelAttribute("dcIncome") DCIncome dcIncome, Model model) {
		
		dcIncomeService.saveDcIncome(dcIncome);
		System.out.println(dcIncome + "Saved");
		
	return "EligibilityDetermination";
	}

}
