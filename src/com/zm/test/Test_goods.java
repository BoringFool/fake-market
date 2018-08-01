package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Goods;
import com.zm.service.IGoodsService;

public class Test_goods {

	@Test
	@SuppressWarnings("resource")
	public void test_goods() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		Goods g=new Goods();
		g.setName("电脑5");
		g.setBrand("Dell");
		g.setColor("black");
		g.setImageurl("url:null");
		g.setNumber(1l);
		g.setPrice(4000.00);
		g.setSize("M");
		g.setStore("LuLuStore");
		String mess=goodsservice.save(g);
		System.out.println(mess);
	}
}
