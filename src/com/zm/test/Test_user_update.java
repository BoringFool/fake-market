package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.User;
import com.zm.service.IUserService;

public class Test_user_update {

	@SuppressWarnings("resource")
	@Test
	public void update(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		User u=userservice.getById(1l);
		u.setEmail("1318593330@qq.com");
		userservice.update(u);
		
		
	}
}
