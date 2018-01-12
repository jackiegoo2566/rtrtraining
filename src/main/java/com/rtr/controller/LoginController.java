package com.rtr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rtr.db.User;
import com.rtr.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}

	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public String login(@RequestParam("iduser") String iduser,
						@RequestParam("password") String password,
						HttpServletRequest request) {
		String page="homepage";
		User rs = loginService.login(iduser, password);
		if(rs!=null) {
			request.getSession().setAttribute("iduser", iduser);
			request.getSession().setAttribute("role", rs.getIdRole());
			if(rs.getIdRole().equals("ch")) {
				page= "chef";
			} else if (rs.getIdRole().equals("wa")) {
				page = "waiter";
			} else if (rs.getIdRole().equals("ma")) {
				page = "manager";
			}
		} else {
			page="login-fail";
		}
		return "redirect:/" + page;
	}
}
