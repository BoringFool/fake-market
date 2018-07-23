package com.zm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zm.model.Goods;
import com.zm.model.OrderList;
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

	@RequestMapping("/pay")
	@ResponseBody
	/*
	 * 直接orderlist接受，里面goods的number属性用来接受数量,
	 * 但是保存到list里面关联上的话，数量和库存冲突。不想给goods再加个属性
	 * */
	public String save(HttpServletRequest req,@RequestBody OrderList o) {
		
		
		
		Set<Goods>  s=o.getGoods();
		System.out.println(s+"*********");
		Iterator<Goods> it=s.iterator();
		for(Goods gg:s) {
			System.out.println(gg.getBrand());
		}
		while(it.hasNext()) {
			Goods g=it.next();
			System.out.println(it);
			System.out.println("******"+g.getBrand());
		}
		
		
		/*long id = Long.parseLong(req.getParameter("id"));
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
		orderlistservice.save(ol);*/

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
					session.setAttribute("shoppingCart", cart);
				}
			} else {
				cart.put(id, num);
				session.setAttribute("shoppingCart", cart);
			}
		}
		return "1";
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static Map<String, String> convertRequestPrama(HttpServletRequest request) throws JSONException {
        Map<String, String> map = new HashMap<String, String>();
        // 读取请求内容
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        StringBuilder sb = new StringBuilder();
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将资料解码
        String reqBody = sb.toString();

        if (StringUtils.isEmpty(reqBody)) return null;

        JSONObject jsonObject = new JSONObject(reqBody);

        Iterator iterator = jsonObject.keys();
        String key = null;
        String value = null;
        while (iterator.hasNext()) {
            key = (String) iterator.next();
            value = jsonObject.getString(key);
            map.put(key, value);
        }
        return map;
	}
}
