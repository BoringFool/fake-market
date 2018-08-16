package com.zm.service;

import java.util.List;

import com.zm.model.User;

public interface IUserService {
	public String save(User u);
	public void delet(long id);
	public void update(User u);
	public List<User> findall();
	public List<User> getByids(Long[] ids);
	public User getByName(String name);
	public void tex();
	public User getById(Long l);
	public void rolesSave(long id,int rn);
}
