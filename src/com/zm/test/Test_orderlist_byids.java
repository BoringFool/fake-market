package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.dao.impl.OrderListDao;
import com.zm.model.Goods;
import com.zm.model.Order;
import com.zm.model.OrderList;
import com.zm.model.User;
import com.zm.service.IGoodsService;
import com.zm.service.IOrderListService;
import com.zm.service.IOrderService;
import com.zm.service.IUserService;
import com.zm.service.impl.OrderListService;

public class Test_orderlist_byids {

	@Test
	@SuppressWarnings("resource")
	public void test_orderlist() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		User u= userservice.getById(1);
		Order o=new Order();
		o.setUsers(u);
		orderservice.save(o);
		long[] ids= {1};
		System.out.println(orderlistservice.getById(2l));
	}
}
