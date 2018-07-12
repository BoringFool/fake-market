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
		User u=userservice.getById(2l);
		u.setName("aa");
		userservice.update(u);
		
		
	}
}
