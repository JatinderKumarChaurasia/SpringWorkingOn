package com.jkc.SecurityApp.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jkc.SecurityApp.entity.User;
import com.jkc.SecurityApp.services.UserService;
import com.jkc.SecurityApp.user.CRMUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(RegistrationController.class.getName());
	
	private Map<String,String> roles;
	
	@PostConstruct
	protected void loadRoles(){
		roles = new LinkedHashMap<String,String>();
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, trimmerEditor);
	}

	@GetMapping("/showRegisterPage")
	public String showRegistrationPage(Model model) {
		model.addAttribute("crmUser", new CRMUser());
		model.addAttribute("roles", roles);
		return "registration-form";
	}

	@PostMapping("/processRegistration")
	public String processingRegistration(@Valid @ModelAttribute("crmUser") CRMUser crmUser, BindingResult bindingResult,
			Model model) {
		
		String userName = crmUser.getUsername();
		logger.info("\t Processing Registration For User Name : "+userName);
		if(bindingResult.hasErrors()){
			return "registration-form";
		}
		// Checking if Username in the database exists
		User user = userService.findUserByUserName(userName);
		if(user != null){
			model.addAttribute("crmUser", new CRMUser());
			model.addAttribute("roles", roles);
			model.addAttribute("registrationError","User Name Already Exists !!");
			logger.warning("User Name Already Exists !!!");
			return "registration-form";
		}else{
			userService.save(crmUser);
			logger.info("User is Registered Successfully with UserName :"+userName+"!!!");
			return "register-confirmation";
		}
	}

}
