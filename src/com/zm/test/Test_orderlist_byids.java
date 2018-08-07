package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Order;
import com.zm.model.User;
import com.zm.service.IOrderListService;
import com.zm.service.IOrderService;
import com.zm.service.IUserService;

public class Test_orderlist_byids {

	@Test
	@SuppressWarnings("resource")
	public void test_orderlist() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		User u= userservice.getById(1l);
		Order o=new Order();
		o.setUsers(u);
		orderservice.save(o);
		Long[] ids= {(long) 1,(long) 2};
		System.out.println(orderlistservice.getByIds(ids)+"*****");
	}
}
