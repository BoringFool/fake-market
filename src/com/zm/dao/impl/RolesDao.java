package com.zm.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.zm.dao.IRolesDao;
import com.zm.model.Roles;

@Component("rolesdao")
public class RolesDao extends BaseDao<Roles> implements IRolesDao {

	@Override
	public Roles getbyName(String name) {
		String hql = "from Roles as r where r.name=:name";
		Query q = getSession().createQuery(hql);
		q.setParameter("name", name);
		return (Roles) q.uniqueResult();
	}

}
