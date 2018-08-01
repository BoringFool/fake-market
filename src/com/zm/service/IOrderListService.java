package com.zm.service;

import java.util.List;

import com.zm.model.OrderList;

public interface IOrderListService {

	public void save(OrderList o_l);

	public void delete(long l);

	public OrderList getById(long l);

	public void update(OrderList ol);

	public List<OrderList> byState(boolean b);
}
