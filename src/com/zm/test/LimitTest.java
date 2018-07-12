package com.zm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Goods;
import com.zm.service.IGoodsService;


public class LimitTest {

	@SuppressWarnings("resource")
	@Test
	public void limit(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService gs=(IGoodsService) ctx.getBean("goodsservice");
		List<Goods> gl=gs.limitq(2,2);
		for(int i=0;i<gl.size();i++){
			System.out.println(gl.get(i).getId());
		}
	}
}
