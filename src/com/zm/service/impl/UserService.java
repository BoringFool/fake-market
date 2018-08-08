package com.zm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IUserDao;
import com.zm.model.User;
import com.zm.service.IUserService;

@Service("userservice")
@Transactional
public class UserService implements IUserService {

	@Resource
	private IUserDao userdao;

	public IUserDao getUserdao() {
		return userdao;
	}

	public void setUserdao(IUserDao userdao) {
		this.userdao = userdao;
	}

	public String save(User u) {
		User user = userdao.getByName(u.getName());
		if (user != null) {
			return "用户已存在";
		} else {
			userdao.add(u);
			return "用户添加成功";
		}
	}

	public void delet(User u) {
		userdao.delet((long) u.getId());
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

}
