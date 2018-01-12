package com.rtr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtr.dao.WaiterDAO;
import com.rtr.db.Item;
import com.rtr.db.Table;

@Service
public class WaiterService {
	@Autowired
	private WaiterDAO waiterDAO;
	
	public List<Table> findAllTable(){
		List<Table> lstTable = waiterDAO.findAllTable();
		return lstTable;
	}
	public List<Item> getAllItem(){
		List<Item> lst = waiterDAO.findAllItem();
		return lst;
	}
	/**
	 * ADD ITEM ORDER
	 * @param idItem 
	 * @param idTable
	 * find table has id = idTable, check if it has an out standing order
	 * if it doesnt, create a new order then add the item (has iditem) then.
	 * if it does, add the item to the order
	 */
	public void addOrderItem(String idItem, int idTable) {
		Table table = waiterDAO.findTableByTableId(idTable);
		if(table.getOutStandingOrder()==null) {
			waiterDAO.createNewOrder();
			waiterDAO.addItemToOrder(table.getOutStandingOrder().getIdOrder(), idItem);
		} else {
			waiterDAO.addItemToOrder(table.getOutStandingOrder().getIdOrder(), idItem);
		}
	}
}
