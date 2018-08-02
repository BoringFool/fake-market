package com.zm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IOrderDao;
import com.zm.dao.IOrderListDao;
import com.zm.dao.IUserDao;
import com.zm.model.Order;
import com.zm.model.OrderList;
import com.zm.model.User;
import com.zm.service.IOrderListService;

@Service("orderlistservice")
@Transactional
public class OrderListService implements IOrderListService {

	@Resource
	private IOrderListDao orderlistdao;

	@Resource
	private IUserDao userdao;

	@Resource
	private IOrderDao orderdao;

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

	@Override
	public boolean saveContainOrder(OrderList ol, String username) {
		User u = userdao.getByName(username);
		Order order = new Order();
		order.setUsers(u);
		ol.setOrder(order);
		orderlistdao.add(ol);

		return true;
	}
}
