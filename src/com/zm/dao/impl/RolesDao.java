package com.zm.dao.impl;

import org.springframework.stereotype.Component;

import com.zm.dao.IRolesDao;
import com.zm.model.Roles;

@Component("rolesdao")
public class RolesDao extends BaseDao<Roles> implements IRolesDao {

}
