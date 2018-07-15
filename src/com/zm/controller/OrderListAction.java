package com.zm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.model.Goods;
import com.zm.model.Order;
import com.zm.model.OrderList;
import com.zm.model.User;
import com.zm.service.IGoodsService;
import com.zm.service.IOrderListService;
import com.zm.service.IOrderService;
import com.zm.service.IUserService;

@Controller
@RequestMapping("/orderlist")
public class OrderListAction {

	@Resource
	private IOrderListService orderlistservice;
	@Resource
	private IGoodsService goodsservice;
	@Resource
	private IUserService userservice;
	@Resource
	private IOrderService orderservice;

	
	
	@RequestMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest req) {
		long id=Long.parseLong(req.getParameter("id"));
		int num=Integer.parseInt(req.getParameter("num"));
		Order order=new Order();
		OrderList ol=new OrderList();
		Goods g=goodsservice.getById(id);
		ol.setNumber(num);
		ol.addGood(g);
		ol.setOrder(order);
		String name=(String) req.getSession().getAttribute("username");
		User u=userservice.getByName(name);
		order.setUser(u);
		orderservice.save(order);
		orderlistservice.save(ol);
		
		
		
		return "1";
	}
}
