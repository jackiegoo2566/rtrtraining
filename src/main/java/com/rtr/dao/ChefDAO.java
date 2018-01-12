package com.rtr.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rtr.db.OrderItem;

@Repository
@SuppressWarnings("unchecked")
public class ChefDAO extends BaseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * FIND ORDER ITEMs 
	 * which has status id = hs or status id = bd for CHEF PAGE
	 * @return list OrderItem
	 */
	@Transactional
	public List<OrderItem> findOrderItemNeeded(){
		return (List<OrderItem>) sessionFactory.getCurrentSession().
				createQuery("from OrderItem where statusId='hs' "
						+ "or statusId='bd'").list();
	}
	
	@Transactional
	public void finishItem(String idorder) {
		
		
	}
	
}



