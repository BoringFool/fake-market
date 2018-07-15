package com.zm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderAction {

	@Resource
	private IOrderService orderservice;

	
}
