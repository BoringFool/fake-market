package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Order;
import com.zm.model.OrderList;
import com.zm.service.IOrderListService;
import com.zm.service.IOrderService;

public class Test_orderlist_update {

	@SuppressWarnings("resource")
	@Test
	public void update_order(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		OrderList ol=orderlistservice.getById(2l);
		System.out.println(ol.getOrder());
		Order o=orderservice.getById(2l);
		System.out.println(o.getId());
		ol.setOrder(o);
		orderlistservice.update(ol);
		OrderList ol1=orderlistservice.getById(2l);
		System.out.println(o.getId());
		
		System.out.println(ol1.getOrder());
	}
}
