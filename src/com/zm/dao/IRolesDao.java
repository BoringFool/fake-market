package com.zm.dao;

import com.zm.model.Roles;

public interface IRolesDao extends IBaseDao<Roles> {

	public Roles getbyName(String name);
}
