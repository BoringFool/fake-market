package com.zm.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IOrderListDao;
import com.zm.model.OrderList;
import com.zm.service.IOrderListService;

@Service("orderlistservice")
@Transactional
public class OrderListService implements IOrderListService {

	@Resource
	private IOrderListDao orderlistdao;

	public IOrderListDao getOrderlistdao() {
		return orderlistdao;
	}

	public void setOrderlistdao(IOrderListDao orderlistdao) {
		this.orderlistdao = orderlistdao;
	}

	@Override
	public void save(OrderList o_l) {
		orderlistdao.add(o_l);

	}

	@Override
	public void delete(long l) {
		orderlistdao.delet(l);
		
	}

	@Override
	public OrderList getById(long l) {
		return orderlistdao.getById(l);
		
	}

	@Override
	public void update(OrderList ol) {
		orderlistdao.update(ol);
		
	}

	@Override
	public List<OrderList> byState(boolean b) {
		return orderlistdao.getByState(b);
	}

	@Override
	public List<OrderList> getByGoodsId(Long id) {
		
		return orderlistdao.byGoodsId(id);
	}
}
