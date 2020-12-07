package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.ies.admin.domain.UsersDomain;
import com.ashokit.ies.admin.service.UsersService;

@Controller
public class RegisterUserController {

	
	
	@Autowired
	UsersService userService;

	@GetMapping("/RegisterUser")
	public String showRegistrationForm(Model model) {

		model.addAttribute("user", new UsersDomain());

		return "RegistrationPage";
	}

	@GetMapping("/")
	public String showIndexPage() {

		return "Index";
	}

	@GetMapping("/uniqueMailCheck")
	public @ResponseBody String isEmailUnique(@RequestParam("email") String email) {

		return userService.isUniqueEmail(email);

	}

	@PostMapping("/Register")
	public String handleSubmitButton(@ModelAttribute("user") UsersDomain user,Model model) {
		
		if (userService.saveUser(user))
			model.addAttribute("succMsg", "Registered Successfully");
		else
			model.addAttribute("failMsg", "Unable to Register");
		
		return "RegistrationPage";
	}
}
