package com.zm.service;

import java.util.List;

import com.zm.model.OrderList;

public interface IOrderListService {

	public void save(OrderList o_l);

	public void delete(long l);

	public OrderList getById(long l);
	
	public List<OrderList> getByIds(long[] ids);

	public void update(OrderList ol);

	public List<OrderList> byState(boolean b);

	public List<OrderList> getByGoodsId(Long id);

	public boolean saveContainOrder(long[] ids , String username);
}
