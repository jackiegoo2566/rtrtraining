package com.rtr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtr.dao.LoginDAO;
import com.rtr.db.User;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	public User login(String iduser,String password) {
		User rs=null;	    
		User user=loginDAO.login(iduser);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				rs=user;
			}
		}
		return rs;
	}
}
