package com.zm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IRolesDao;
import com.zm.dao.IUserDao;
import com.zm.model.Roles;
import com.zm.model.User;
import com.zm.service.IUserService;

@Service("userservice")
@Transactional
public class UserService implements IUserService {

	@Resource
	private IUserDao userdao;
	@Resource
	private IRolesDao rolesDao;

	public IUserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDao userdao) {
		this.userdao = userdao;
	}

	public Long save(User u) {
		User user = userdao.getByName(u.getName());
		if (user != null) {
			return 0l;
		} else {
			while (u.getRoles().isEmpty()) {
				Roles r = rolesDao.getbyName("顾客");
				u.getRoles().add(r);
			}
			userdao.add(u);
			return 1l;
		}
	}

	public void delet(long id) {
		userdao.delet(id);
	}

	public void update(User u) {
		userdao.update(u);
	}

	public List<User> findall() {
		return userdao.findall();
	}

	public List<User> getByids(Long[] ids) {
		return userdao.getByIds(ids);
	}

	public User getByName(String name) {
		return userdao.getByName(name);
	}

	public void tex() {
		userdao.connect_ineer();
	}

	@Override
	public User getById(Long l) {

		return userdao.getById(l);
	}

	@Override
	// 实体是多对多，实际用的为一对一，所以iterator的遍历如下
	public void rolesSave(long id, String name) {
		Roles r = rolesDao.getbyName(name);
		User u = userdao.getById(id);
		Set<Roles> setR = u.getRoles();
		Iterator<Roles> itR = setR.iterator();
		while (itR.hasNext()) {
			// 不先next直接删除会报错
			itR.next();
			itR.remove();
		}
		setR.add(r);
		userdao.update(u);
	}

	@Override
	public List<User> likeSearch(boolean whichO, String key) {
		if (whichO) {
			Roles r = rolesDao.getbyName(key);
			List<User> ul = new ArrayList<User>();
			ul.addAll(r.getUser());
			return ul;
		} else {
			return userdao.like(key);
		}

	}

	@Override
	public boolean checkPassword(User u) {
		User user = userdao.getByName(u.getName());
		return u.getPassword().equals(user.getPassword());
	}

	@Override
	public boolean changePass(String userName, String old, String newOne) {
		User u = userdao.getByName(userName);
		if (u.getPassword().equals(old)) {
			u.setPassword(newOne);
			userdao.update(u);
			return true;
		} else {
			return false;
		}
	}

}
