package com.zm.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Roles;
import com.zm.model.Stock;
import com.zm.model.User;
import com.zm.service.IRolesService;
import com.zm.service.IStockService;
import com.zm.service.IUserService;

/*
 * 添加第一步
 * */
public class Test_user {

	@Test
	@SuppressWarnings("resource")
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice = (IUserService) ctx.getBean("userservice");
		User u = new User();
		u.setName("zm22");
		u.setEmail("1318593330@qq.com");
		u.setPassword("123456a");
		Long a = userservice.save(u);
		userservice.getById(1l);
		System.out.println(a);
		Roles r = new Roles();
		r.setName("商人");
	}

	@SuppressWarnings("resource")
	@Test
	public void test_roles() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice = (IUserService) ctx.getBean("userservice");
		IRolesService rolesservice = (IRolesService) ctx.getBean("rolesservice");
		User u = userservice.getById(1l);
		Roles r = new Roles();
		r.setName("商人");
		u.getRoles().add(r);
		rolesservice.save(r);
		userservice.update(u);
	}

	@SuppressWarnings("resource")
	@Test
	public void test_stock() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice = (IUserService) ctx.getBean("userservice");
		IStockService stockservice = (IStockService) ctx.getBean("stockservice");
		User u = userservice.getById(4l);
		Stock s = new Stock();
		u.setStock(s);
		stockservice.save(s);
		userservice.update(u);

	}

	@SuppressWarnings("resource")
	@Test
	public void test_saveStock() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice = (IUserService) ctx.getBean("userservice");
		IStockService stockservice = (IStockService) ctx.getBean("stockservice");
		User u = userservice.getById(3l);
		Stock stock = stockservice.getById(4l);
		u.setStock(stock);
		userservice.update(u);

	}

	@SuppressWarnings("resource")
	@Test
	public void test_rolesSave() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice = (IUserService) ctx.getBean("userservice");
		userservice.rolesSave(1, "游客");
	}

	@SuppressWarnings("resource")
	@Test
	public void test_likeSearch() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice = (IUserService) ctx.getBean("userservice");
		List<User> listU = userservice.likeSearch(false, "1");
		Iterator<User> it = listU.iterator();
		while (it.hasNext()) {
			System.out.println("******************");
			System.out.println(it.next().getId());
		}
	}
}
