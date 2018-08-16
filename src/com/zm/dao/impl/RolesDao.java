package com.zm.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.zm.dao.IRolesDao;
import com.zm.model.Roles;
import com.zm.model.RolesName;

@Component("rolesdao")
public class RolesDao extends BaseDao<Roles> implements IRolesDao {

	@Override
	public Roles getbyName(RolesName rolesN) {
		RolesName[] nameR= RolesName.values();
		
		String hql="from Roles as r where r.name=:name";
		Query q=getSession().createQuery(hql);
		for(int i=0;i<=nameR.length;i++) {
			if(rolesN==nameR[i]) {
				q.setParameter("name", i);
				break;
			}
		}
		return (Roles) q.uniqueResult();
	}

	

}
