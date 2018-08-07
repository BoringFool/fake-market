package com.zm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zm.dao.IBaseDao;

@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {

	@Resource
	private SessionFactory sessionfactory;
	Class<T> clazz;

	public BaseDao() {
		ParameterizedType t = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] a = t.getActualTypeArguments();
		clazz = (Class<T>) a[0];
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public void add(T entity) {
		Session session = getSession();
		session.save(entity);
	}

	@Override
	public void delet(long id) {
		Session session = getSession();
		session.delete(getSession().get(clazz, id));

	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public List<T> findall() {
		String hql = "FROM " + clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	@Override
	public T getById(long id) {
		return (T) getSession().get(clazz,id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		String hql = "FROM " + clazz.getSimpleName() + " WHERE ID in(:ids)";
		Query q = getSession().createQuery(hql);
		q.setParameterList("ids", ids);
		return q.list();
	}

	public Session getSession() {
		return sessionfactory.getCurrentSession();
	}

}
