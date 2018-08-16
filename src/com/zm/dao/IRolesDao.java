package com.zm.dao;

import com.zm.model.Roles;
import com.zm.model.RolesName;

public interface IRolesDao extends IBaseDao<Roles> {

	public Roles getbyName(RolesName rolesN);
}
