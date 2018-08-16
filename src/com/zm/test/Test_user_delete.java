package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.User;
import com.zm.service.IUserService;

/*
 * 第三步删除
 * */
public class Test_user_delete {

	@SuppressWarnings("resource")
	@Test
	public void Test_delete(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		User u=userservice.getById(1l);
		userservice.delet(u.getId());
	}
}
