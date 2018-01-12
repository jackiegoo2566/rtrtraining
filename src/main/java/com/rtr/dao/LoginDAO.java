package com.rtr.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rtr.db.User;

@Repository
public class LoginDAO extends BaseDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public User login(String iduser) {
		return (User)  sessionFactory.getCurrentSession().
				get(com.rtr.db.User.class, iduser);
	}
}