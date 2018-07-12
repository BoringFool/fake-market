package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.service.IGoodsService;

public class Test_goods_delete {

	@SuppressWarnings("resource")
	@Test
	public void delete(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService goodservice=(IGoodsService) ctx.getBean("goodsservice");
		goodservice.delete(1l);
	}
}
