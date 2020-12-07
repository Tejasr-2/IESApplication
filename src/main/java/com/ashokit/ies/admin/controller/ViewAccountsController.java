package com.ashokit.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.ies.admin.domain.UsersDomain;
import com.ashokit.ies.admin.service.UsersService;

@Controller
public class ViewAccountsController {

	@Autowired
	UsersService userService;

	@GetMapping("/ViewAccounts")
	public String showViewAccountsForm(Model model) {

		List<UsersDomain> users = userService.getAllUsersByRole("Admin");

		model.addAttribute("users", users);

		return "ViewAccounts";
	}

	@GetMapping("/editUser")
	public String editUser(@RequestParam("uid") int uid, Model model) {

		UsersDomain user = userService.findByUid(uid);
		

		model.addAttribute("user", user);

		return "RegistrationPage";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("uid") int uid, Model model) {
		userService.deactivateUser(uid);
		UsersDomain user = userService.findByUid(uid);	
		String role = user.getRole();
		List<UsersDomain> users = userService.getAllUsersByRole(role);
		model.addAttribute("users", users);
		return "ViewAccounts";
	}
	
	@GetMapping("/activateUser")
	public String activateUser(@RequestParam("uid") int uid, Model model) {
		userService.activateUser(uid);
		UsersDomain user = userService.findByUid(uid);
		String role = user.getRole();
		List<UsersDomain> users = userService.getAllUsersByRole(role);
		model.addAttribute("users", users);
		
		return "ViewAccounts";
	}
	
	

	@GetMapping("/getUsersByRole")
	public @ResponseBody List<UsersDomain> getUsersByRole(@RequestParam("role") String role) {

		return userService.getAllUsersByRole(role);

	}

}
