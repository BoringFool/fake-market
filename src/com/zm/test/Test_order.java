package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Order;
import com.zm.model.User;
import com.zm.service.IOrderService;
import com.zm.service.IUserService;

/*
 * 添加第二步
 * */
public class Test_order {

	@Test
	@SuppressWarnings("resource")
	public void test_order() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		
		User u=userservice.getById(1l);
		Order o=new Order();
		o.setAge(25);
		o.setName("zz");
		o.setNum(1);
		o.setUser(u);
		orderservice.save(o);
		System.out.println(o.getId());
	}
}
