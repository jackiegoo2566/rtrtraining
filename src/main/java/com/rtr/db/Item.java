package com.rtr.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@Entity
@Table(name="item", schema="rtrdb")
public class Item implements Serializable{
	@Id
	@Column(name="idItem")
	private String idItem;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@JsonIgnoreProperties("item")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="item", fetch=FetchType.EAGER)
	private List<OrderItem> lstOrderItem;
	

	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<OrderItem> getLstOrderItem() {
		return lstOrderItem;
	}
	public void setLstOrderItem(List<OrderItem> lstOrderItem) {
		this.lstOrderItem = lstOrderItem;
	}
}
