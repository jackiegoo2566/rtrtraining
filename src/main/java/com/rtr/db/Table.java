package com.rtr.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name="table", schema="rtrdb")
public class Table implements Serializable {
	@Id
	@Column(name="idTable")
	private int idTable;
	
	@Column(name="type")
	private String type;
	
	@JsonIgnoreProperties("table")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="table", fetch=FetchType.EAGER)
	private List<Order> lstOrder;		

	@JsonIgnoreProperties("table")
	public Order getOutStandingOrder() {
		for(Order order:lstOrder) {
			if(order.getIdStatus().equals("hp")) {
				return order;
			}
		}
		return null;
	}
	
	@JsonIgnoreProperties("table")
	public String getTableStatus() {
		String status = "ready";
		for(Order order:lstOrder) {
			if(order.getIdStatus().equals("hp")) {
				status="using";
			}
		}
		return status;
	}
	
	public int getIdTable() {
		return idTable;
	}
	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Order> getLstOrder() {
		return lstOrder;
	}
	public void setLstOrder(List<Order> lstOrder) {
		this.lstOrder = lstOrder;
	}	
}
