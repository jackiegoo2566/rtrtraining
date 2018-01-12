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
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="role", schema="rtrdb")
public class Role implements Serializable{
	@Id
	@Column(name="idRole")
	private String idRole;
	
	@Column(name="nameRole")
	private String nameRole;
	
	@JsonIgnoreProperties("role")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="role", fetch=FetchType.EAGER)
	private List<User> lstUser;

	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public List<User> getLstUser() {
		return lstUser;
	}
	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}
}
