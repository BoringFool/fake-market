package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IGoodsService;

public class Test_goods_count {

	@SuppressWarnings("resource")
	@Test
	public void count() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		Long a=goodsservice.count();
		System.out.println(a);
	}
}
