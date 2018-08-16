package com.zm.service;

import java.util.List;

import com.zm.model.Roles;

public interface IRolesService {

	public void save(Roles r);

	public void delete(long id);

	public void update(Roles r);

	public Roles getById(long id);
	
	public List<Roles> findall();
	
	public void defaultR();
}
