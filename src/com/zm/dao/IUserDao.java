package com.zm.dao;

import com.zm.model.User;

public interface IUserDao extends IBaseDao<User> {

	public User getByName(String name);
	public void connect_ineer();

}
