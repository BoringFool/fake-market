package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Goods;
import com.zm.model.Order;
import com.zm.model.OrderList;
import com.zm.service.IGoodsService;
import com.zm.service.IOrderListService;
import com.zm.service.IOrderService;

/*
 * 添加第三步
 * */
public class Test_orderlist {

	@Test
	@SuppressWarnings("resource")
	public void test_orderlist() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		Order o=orderservice.getById(1l);
		Goods g=goodsservice.getById(2l);
		OrderList o_l=new OrderList();
		o_l.setOrder(o);
 		o_l.setGoods(g);
		orderlistservice.save(o_l);
		System.out.println(o_l.getId());
	}
}
