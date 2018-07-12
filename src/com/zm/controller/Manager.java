package com.zm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.service.IGoodsService;

@Controller
@RequestMapping("manager")
public class Manager {
	@Resource
	private IGoodsService goodsservice;
	
}
