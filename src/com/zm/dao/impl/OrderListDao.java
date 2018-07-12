package com.zm.dao.impl;


import org.springframework.stereotype.Component;

import com.zm.dao.IOrderListDao;
import com.zm.model.OrderList;

@Component("orderlistdao")
public class OrderListDao extends BaseDao<OrderList> implements IOrderListDao {



}
