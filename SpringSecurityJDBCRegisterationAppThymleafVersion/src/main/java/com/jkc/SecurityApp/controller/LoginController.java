package com.jkc.SecurityApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage(Model model) {
//		return "custom-login-page";
		model.addAttribute("message","Hello From Thymeleaf");
		return "fancy-login";
	}
	
	@GetMapping("/access-denied")
	public String accessDeniedPage(){
		return "access-denied";
	}
}
