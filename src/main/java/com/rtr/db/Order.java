package com.rtr.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@javax.persistence.Table(name="order", schema="rtrdb")
public class Order implements Serializable {	
	@Id
	@Column(name="idOrder")
	private String idOrder;

	@Column(name="idStatus")
	private String idStatus;
	
	@Column(name="sum")
	private double sum;
		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idTable", referencedColumnName="idTable", nullable=false, insertable=false, updatable=false)
	private Table table;

//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="idUser", nullable=false, insertable=false, updatable=false)
//	private User user;


	@JsonIgnoreProperties("order")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order", fetch=FetchType.EAGER)
	private List<OrderItem> lstOrderItem;

	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public List<OrderItem> getLstOrderItem() {
		return lstOrderItem;
	}
	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
		this.lstOrderItem = lstOrderItem;
	}
	public String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
}
