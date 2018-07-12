package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Goods;
import com.zm.model.OrderList;
import com.zm.service.IGoodsService;
import com.zm.service.IOrderListService;

public class Test_orderlist_update_goods {

	@SuppressWarnings("resource")
	@Test
	public void updaet(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		IGoodsService goodservice=(IGoodsService) ctx.getBean("goodsservice");
		Goods g=goodservice.getById(3l);
		OrderList o=orderlistservice.getById(1l);
		o.getGoods().add(g);
		orderlistservice.update(o);
		
	}
}
