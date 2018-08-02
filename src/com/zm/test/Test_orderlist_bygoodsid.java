package com.zm.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.OrderList;
import com.zm.service.IOrderListService;

public class Test_orderlist_bygoodsid {

	@Test
	@SuppressWarnings("resource")
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		List<OrderList> o=orderlistservice.getByGoodsId(2l);
		System.out.println(o);
	}
}
