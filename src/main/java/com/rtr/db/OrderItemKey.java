package com.rtr.db;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class OrderItemKey implements Serializable{
	@Column(name="idOrder")
	private String idOrder;
	
	@Column(name="idItem")
	private String idItem;

	
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
}
