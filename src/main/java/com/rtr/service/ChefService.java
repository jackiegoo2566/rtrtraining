package com.rtr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtr.dao.ChefDAO;
import com.rtr.db.OrderItem;

@Service
public class ChefService {

	@Autowired
	private ChefDAO chefDAO;
	/**
	 * GET ORDER ITEM NEEDED
	 * @return list OrderItem
	 */
	public List<OrderItem> getOrderItemNeeded(){
		List<OrderItem> lst = chefDAO.findOrderItemNeeded();
		return lst;
	}
	
	
	
	
}

