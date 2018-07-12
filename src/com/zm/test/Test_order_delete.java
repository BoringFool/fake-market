package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IOrderService;

/*
 * 第二步删除
 * */
@SuppressWarnings("resource")
public class Test_order_delete {

	@Test
	public void test_delete(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		orderservice.delete(1l);
	}
}
