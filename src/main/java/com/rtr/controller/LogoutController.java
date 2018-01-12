package com.rtr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/logout")
public class LogoutController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.getSession().removeAttribute("iduser");
		request.getSession().removeAttribute("role");
		String redirectURL = "login";
		response.sendRedirect(redirectURL);
		return "logout";
	}
}
