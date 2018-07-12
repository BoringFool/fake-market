package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IOrderListService;
/*
 * 第一步删除
 * 
 * */
public class Test_orderlist_delete {

	@SuppressWarnings("resource")
	@Test
	public void test_delet(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		orderlistservice.delete(1l);
		
	}
}
