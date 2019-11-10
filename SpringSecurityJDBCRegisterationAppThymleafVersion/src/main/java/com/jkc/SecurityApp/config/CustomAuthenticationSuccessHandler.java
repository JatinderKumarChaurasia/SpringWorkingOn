package com.jkc.SecurityApp.config;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.jkc.SecurityApp.entity.User;
import com.jkc.SecurityApp.services.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	private Logger logger = Logger.getLogger(CustomAuthenticationSuccessHandler.class.getName());

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
			throws IOException, ServletException {
		logger.info("\t\t\t\tIn Authentication Success Method =====\t\t\t\t");
		System.out.println("\n\t\t IN ON AUTHENTICATION HANDLER -=-=-=_=-=_)=D=DS=AW=W=W=QW=W=W=WE=WE==E=E=QW=");
		String userName = arg2.getName();
		System.out.println("\t User Name : " + userName);
		logger.info("\t User Name :"+userName);
		User user = userService.findUserByUserName(userName);
		HttpSession session = arg0.getSession();
		session.setAttribute("user", user);
		arg1.sendRedirect(arg0.getContextPath() + "/");
	}

}
