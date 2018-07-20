package com.zm.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
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
		long id = Long.parseLong(req.getParameter("id"));
		int num = Integer.parseInt(req.getParameter("num"));
		Order order = new Order();
		OrderList ol = new OrderList();
		Goods g = goodsservice.getById(id);
		ol.setNumber(num);
		ol.addGood(g);
		ol.setOrder(order);
		String name = (String) req.getSession().getAttribute("username");
		User u = userservice.getByName(name);
		order.setUsers(u);
		orderservice.save(order);
		orderlistservice.save(ol);

		return "1";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cart")
	@ResponseBody
	public String cart(HttpServletRequest req) {
		long id = Long.parseLong(req.getParameter("id"));
		int num = Integer.parseInt(req.getParameter("num"));
		HttpSession session = req.getSession();
		if (session.getAttribute("shoppingCart") == null) {
			Map<Long, Integer> cart = new HashMap<Long, Integer>();
			cart.put(id, num);
			session.setAttribute("shoppingCart", cart);
		} else {
			HashMap<Long, Integer> cart = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
			Set<Long> keySet = cart.keySet();
			if (keySet.contains(id)) {
				if (req.getParameter("times") == null) {
					return "2";
				} else {
					cart.put(id, num);
					System.out.println(keySet);
					System.out.println(cart.values());
					System.out.println(cart.get(id));
					session.setAttribute("shoppingCart", cart);
				}
			} else {
				cart.put(id, num);
				session.setAttribute("shoppingCart", cart);
			}
		}
		return "1";
	}
}
