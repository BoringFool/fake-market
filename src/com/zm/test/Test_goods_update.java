package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Goods;
import com.zm.service.IGoodsService;

public class Test_goods_update {

	@SuppressWarnings("resource")
	@Test
	public void update(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService goodservice=(IGoodsService) ctx.getBean("goodsservice");
		Goods g=goodservice.getById(1l);
		g.setColor("red");
		goodservice.update(g);
		
	}
}
