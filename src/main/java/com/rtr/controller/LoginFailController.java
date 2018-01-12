package com.rtr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login-fail")
public class LoginFailController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginFail() {
		return "login-fail-page";
	}

}