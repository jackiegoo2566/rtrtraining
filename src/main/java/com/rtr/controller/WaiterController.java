package com.rtr.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rtr.db.Item;
import com.rtr.db.Order;
import com.rtr.db.Table;
import com.rtr.service.WaiterService;

@Controller
@RequestMapping("/waiter")
public class WaiterController {
	@Autowired
	private WaiterService waiterService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String goToWaiter (HttpServletRequest request, HttpServletResponse response) 
			throws IOException {		
		String iduser=(String)request.getSession().getAttribute("iduser");
		String role=(String)request.getSession().getAttribute("role");
		if(iduser==null||iduser.equals("")||!role.equals("wa")){
			String redirectURL = "logout";
			response.sendRedirect(redirectURL);
	    }
		return "waiter";
	}	
	/**
	 * get ALL TABLE (WAITER PAGE)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getTable", method=RequestMethod.GET)
	public List<Table> getTable(){
		List<Table> lst = waiterService.findAllTable();
		return lst;
	}
	/**
	 * get ITEM (ITEM POPUP)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getItem", method=RequestMethod.GET)
	public List<Item> getListItem(){
		List<Item> lstItem = waiterService.getAllItem();
		return lstItem;
	}
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	public String addOrderItem(@RequestParam("idItem") String idItem,
							   @RequestParam("idTable") int idTable) {
		waiterService.addOrderItem(idItem, idTable);
		return "redirect:/waiter";
	}
	
	/**
	 * BILL 
	 * @param idTable
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getBill", method=RequestMethod.GET)
	public Order getBill(@RequestParam("idTable") int idTable) {
		Order order = null;
		return order;
	}	
	@RequestMapping(value="/export", method=RequestMethod.POST)
	public String payBill(@RequestParam("idTable") int idTable) {
		
		return "redirect:/waiter";
	}

}










