package com.zm.dao;

import java.util.List;

import com.zm.model.User;

public interface IUserDao extends IBaseDao<User> {

	public User getByName(String name);

	public void connect_ineer();

	public List<User> like(String key);

	public void name();

	public void zm();
}
