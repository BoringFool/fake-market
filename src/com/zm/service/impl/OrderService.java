package com.zm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IOrderDao;
import com.zm.model.Order;
import com.zm.service.IOrderService;
@Service("orderservice")
@Transactional
public class OrderService implements IOrderService {

	@Resource
	private IOrderDao orderdao;

	public IOrderDao getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(IOrderDao orderdao) {
		this.orderdao = orderdao;
	}

	@Override
	public void save(Order o) {
		orderdao.add(o);
		
	}

	@Override
	public Order getById(long l) {
		
		return orderdao.getById(l);
	}

	@Override
	public void upadte(Order o) {
		orderdao.update(o);
		
	}

	@Override
	public void delete(long id) {
		orderdao.delet(id);
		
	}
}
