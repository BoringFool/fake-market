package com.zm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IRolesDao;
import com.zm.model.Roles;
import com.zm.model.RolesName;
import com.zm.service.IRolesService;

@Service("rolesservice")
@Transactional
public class RolesService implements IRolesService {

	@Resource
	IRolesDao rolesdao;

	@Override
	public void save(Roles r) {
		rolesdao.add(r);
	}

	@Override
	public void delete(long id) {
		rolesdao.delet(id);

	}

	@Override
	public void update(Roles r) {

		rolesdao.update(r);
	}

	@Override
	public Roles getById(long id) {

		return rolesdao.getById(id);
	}

	@Override
	public void defaultR() {
		for (RolesName e : RolesName.values()) {
			Roles r = new Roles();
			r.setName(e);
			rolesdao.add(r);
		}
	}

	@Override
	public List<Roles> findall() {
		
		return rolesdao.findall();
	}

}
