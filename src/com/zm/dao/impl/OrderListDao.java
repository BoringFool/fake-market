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
		String hql;
		if (b) {
			hql = "FROM OrderList  ol WHERE ol.order !=null";
		} else {
			hql = "FROM OrderList  ol WHERE ol.order =null";
		}
		Query q = getSession().createQuery(hql);
		List<OrderList> l = q.list();
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderList> byGoodsId(Long id) {
		String hql = "from OrderList ol where ol.goods.id=:ids";
		Query q = getSession().createQuery(hql);
		q.setString("ids", id.toString());

		List<OrderList> o = q.list();
		return o;
	}

	public long countCart() {
		String hql = "select count(*) from OrderList o where o.order=null";
		Query q = getSession().createQuery(hql);
		long number = (long) q.iterate().next();
		return number;
	}

}
