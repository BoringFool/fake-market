package com.zm.dao;

import java.util.List;

public interface IBaseDao<T> {
	
	public void add(T entity);

	public void delet(long id);

	public void update(T entity);

	public List<T> findall();

	public T getById(long id);

	public List<T> getByIds(long[] ids);
}
