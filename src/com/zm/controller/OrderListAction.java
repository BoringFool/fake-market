package com.zm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.service.IOrderListService;

@Controller
@RequestMapping("/orderlist")
public class OrderListAction {

	@Resource
	private IOrderListService orderlistservice;

	public IOrderListService getOrderlistservice() {
		return orderlistservice;
	}

	public void setOrderlistservice(IOrderListService orderlistservice) {
		this.orderlistservice = orderlistservice;
	}
}
