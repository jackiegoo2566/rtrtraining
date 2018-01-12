package com.rtr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtr.db.OrderItem;
import com.rtr.service.ChefService;

@Controller
@RequestMapping(value="/chef")
public class ChefController {
	@RequestMapping(method=RequestMethod.GET)
	public String goToChef (HttpServletRequest request, HttpServletResponse response) 
			throws IOException {		
		String iduser=(String)request.getSession().getAttribute("iduser");
		String role=(String)request.getSession().getAttribute("role");
		if(iduser==null||iduser.equals("")||!role.equals("ch")){
			String redirectURL = "logout";
			response.sendRedirect(redirectURL);
	    }
		return "chef";
	}
	
	@Autowired
	private ChefService orderItemService;
	
	@ResponseBody
	@RequestMapping(value="/getOrderItem", method=RequestMethod.GET)
	public List<OrderItem> getOrderItem() {
		List<OrderItem> lst = orderItemService.getOrderItemNeeded();
		return lst;
	}
	
}

