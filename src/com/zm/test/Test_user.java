package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.User;
import com.zm.service.IUserService;
/*
 * 添加第一步
 * */
public class Test_user {

	@Test
	@SuppressWarnings("resource")
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		User u=new User();
		u.setName("zm22");
		u.setEmail("1318593330@qq.com");
		u.setPassword("123456a");
		String a=userservice.save(u);
		userservice.getById(1l);
		System.out.println(a);
	}

}
