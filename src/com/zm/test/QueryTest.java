package com.zm.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IUserService;

public class QueryTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IUserService us=(IUserService) ctx.getBean("userservice");
		us.tex();
	}

}
