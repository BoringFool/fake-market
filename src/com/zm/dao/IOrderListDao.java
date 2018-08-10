package com.zm.dao;


import java.util.List;

import com.zm.model.OrderList;

public interface IOrderListDao extends IBaseDao<OrderList> {
	public List<OrderList> getByState(boolean b);
	public List<OrderList> byGoodsId(Long id);
	public long countCart();
}
