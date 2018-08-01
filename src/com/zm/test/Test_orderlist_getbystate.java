package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IOrderListService;




public class Test_orderlist_getbystate {

	@Test
	@SuppressWarnings("resource")
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		orderlistservice.byState(false);
	}
	
	
}
