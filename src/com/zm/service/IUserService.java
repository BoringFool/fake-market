package com.zm.service;

import java.util.List;

import com.zm.model.User;

public interface IUserService {
	public String save(User u);
	public void delet(User u);
	public void update(User u);
	public List<User> findall();
	public List<User> getByids(long[] ids);
	public User getByName(String name);
	public void tex();
	public User getById(long l);
}
