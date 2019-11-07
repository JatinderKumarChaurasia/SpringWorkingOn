package com.jkc.SecurityApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String showLanding() {
		return "index";
	}
	@GetMapping("/employees")
	public String showHome() {
		return "home";
	}
}
