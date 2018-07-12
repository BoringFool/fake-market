package com.zm.dao.impl;


import org.springframework.stereotype.Component;

import com.zm.dao.IOrderDao;
import com.zm.model.Order;

@Component("orderdao")
public class OrderDao extends BaseDao<Order> implements IOrderDao {

	

}
