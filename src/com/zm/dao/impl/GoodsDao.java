package com.zm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.zm.dao.IGoodsDao;
import com.zm.model.Goods;

@Component("goodsdao")
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> limitquery(int num,int length) {
		
		String hql="From Goods g";
		Query query=getSession().createQuery(hql);
		return query.setFirstResult(num).setMaxResults(length).list();
	}

	@Override
	public long countNum() {
		String hql="SELECT COUNT(*) From Goods g";
		long count=(long) getSession().createQuery(hql).iterate().next();
		return count;
	}

	@Override
	public Goods getByName(String name) {
		String hql = "FROM Goods as g WHERE g.name='" + name + "'";
		Query q = getSession().createQuery(hql);
		if (q.list().size() != 0) {
			return (Goods) q.list().get(0);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Goods> likeAndLimit(String what,int start,int number){
		String hql="from Goods as g where g.name like :zm";
		Query q=getSession().createQuery(hql);
		q.setString("zm","%"+ what+"%");
		return (List<Goods>) q.setFirstResult(start).setMaxResults(number).list();
	}

}
