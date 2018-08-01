package com.zm.dao.impl;


import java.util.*;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.zm.dao.IOrderListDao;
import com.zm.model.OrderList;

@Component("orderlistdao")
public class OrderListDao extends BaseDao<OrderList> implements IOrderListDao {

	@SuppressWarnings("unchecked")
	public List<OrderList> getByState(boolean b) {
		String hql="FROM OrderList  ol WHERE ol.payState=:state";
		Query q=getSession().createQuery(hql);
		if(b) {
			q.setString("state", "1");
		}else {
			q.setString("state", "0");
		}
		List<OrderList> l=q.list();
		return l;
	}

}
