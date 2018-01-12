package com.rtr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rtr.db.Item;
import com.rtr.db.Order;
import com.rtr.db.OrderItem;
import com.rtr.db.OrderItemKey;
import com.rtr.db.Table;

@SuppressWarnings("unchecked")
@Repository
public class WaiterDAO extends BaseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * FIND ALL TABLE
	 * @return List Table contains all current table
	 */
	@Transactional
	public List<Table> findAllTable(){
		return (List<Table>) sessionFactory.getCurrentSession().
				createQuery("from Table").list();
	}	
	
	/**
	 * FIND ALL ITEM
	 * @return List Item contains all current item
	 */
	@Transactional
	public List<Item> findAllItem(){
		return (List<Item>) sessionFactory.getCurrentSession().
				createQuery("from Item").list();
	}

	/**
	 * FIND TABLE by TABLE ID
	 * @param tableId
	 * @return Table has id = tableId
	 */
	@Transactional
	public Table findTableByTableId(int tableId) {
		return (Table) sessionFactory.getCurrentSession().
				createQuery("from Table where idTable="+tableId).uniqueResult();
	}
	/**
	 * COUNT ORDER
	 * count all order in database
	 * @return numbers of the list
	 */
	@Transactional
	public int countOrder() {
		String hql = "select count(*) from Order";
		return (int) (((Long) sessionFactory.getCurrentSession().
				createQuery(hql).uniqueResult()).intValue());
	}
	/**
	 * CREATE ORDER
	 * create a new order
	 */
	@Transactional
	public void createNewOrder() {
		Order order=new Order();
		order.setIdOrder("00"+countOrder());
		order.setIdStatus("hp");
		order.setSum(0);
		String hql = "Insert into Order(idOrder,idStatus,sum)";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("idOrder", "00"+countOrder());
		query.setParameter("idStatus", "hp");
		query.setParameter("sum", 0);	
	}
	/**
	 * ADD A ITEM TO  ORDER
	 * add item (has iditem) to a existing order (has idorder)
	 * @param idOrder
	 * @param idItem
	 */
	@Transactional
	public void addItemToOrder(String idOrder, String idItem) {
		OrderItem orderItem = new OrderItem();
		OrderItemKey key = new OrderItemKey();
		orderItem.setKey(key);
		orderItem.getKey().setIdItem(idItem);
		orderItem.getKey().setIdOrder(idOrder);
		orderItem.setStatusId("hs");
		sessionFactory.getCurrentSession().save(orderItem);
	}
}











