package com.rtr.db;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name="order_item", schema="rtrdb")
public class OrderItem implements Serializable{
	@EmbeddedId
	private OrderItemKey key;
	
	@Column(name="time")
	private Timestamp time;		
	
	@Column(name="idStatus")
	private String statusId;
	
	@JsonIgnoreProperties("lstOrderItem")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idItem", nullable=false, insertable=false, updatable=false)
	private Item item;
	
	public String getStatusOrderItemByStatusId() {
		if(statusId.equals("bd")) {
			return "Been Doing";
		} else if(statusId.equals("nbp")){
			return "Waiting...";
		} else {
			return "Finished";
		}
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idOrder", nullable=false, insertable=false, updatable=false)
	private Order order;


	public OrderItemKey getKey() {
		return key;
	}
	public void setKey(OrderItemKey key) {
		this.key = key;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
