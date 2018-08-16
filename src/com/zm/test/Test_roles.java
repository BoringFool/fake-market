package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IRolesService;

public class Test_roles {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		IRolesService rolesService=(IRolesService) context.getBean("rolesservice");
		rolesService.defaultR();
	}
}
