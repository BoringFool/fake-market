package com.zm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	/*
	 * 直接OrderList接收,结算
	 */
	@RequestMapping("/paylist")
	@ResponseBody
	public String paylist(HttpServletRequest req, @RequestBody Long[] o) {
		System.out.println(Arrays.toString(o) +"***"+o[0]);
		boolean b=orderlistservice.saveContainOrder(o, (String)req.getSession().getAttribute("username"));
		if(b) {
		return "1";
		}else {
			return "0";
		}
	}

	@RequestMapping("/statelist")
	@ResponseBody
	//未使用和已购买数据查询
	public List<OrderList> list(@RequestParam("bool") Boolean b) {
		return orderlistservice.byState(b);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cart")
	@ResponseBody
	//复杂版的cart保存在session
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

	@SuppressWarnings("unchecked")
	@RequestMapping("/aaa")
	@ResponseBody
	//查询session中保存的cart数据，用作新添加展示
	public Map<Long, Integer> show(HttpServletRequest req) {
		HttpSession session = req.getSession();
		Map<Long, Integer> cart = new HashMap<>();
		// 不可以return null，会导致XML找不到根元素错误
		if (session.getAttribute("shoppingCart") == null) {
			cart.put(0l, 0);
		} else {
			cart = (HashMap<Long, Integer>) session.getAttribute("shoppingCart");
		}
		return cart;
	}

	@SuppressWarnings("unused")
	//本来是用来遍历session中cart数据，后来没用了，就没有删除
	private void mapIt(Map<Long, Integer> s) {
		System.out.println(s);
		Set<Long> ss = s.keySet();
		Iterator<Long> it = ss.iterator();
		while (it.hasNext()) {
			Long l = it.next();
			System.out.println("key :" + l + "values:" + s.get(l));
		}
	}

	@RequestMapping("/add")
	@ResponseBody
	//保存cart数据保存到session的同时保存到数据库
	public String add(@RequestBody OrderList ol, HttpServletRequest req) {
		List<OrderList> olist = orderlistservice.getByGoodsId(ol.getGoods().getId());
		if (olist.size() == 0) {
			orderlistservice.save(ol);
		} else if (olist.size() >= 1) {
			//已存在包含goods的orderList时，以下判断
			int count=0;
			for (OrderList o : olist) {
				if(o.getOrder()==null) {
					o.setNumber(ol.getNumber());
					orderlistservice.update(o);
					break;
				}else{
					count++;
				}
			}
			if(count==olist.size()) {
				orderlistservice.save(ol);
			}
		}
		return "1";
	}

	@SuppressWarnings("rawtypes")
	//好奇怎么用流从request中拿到文件，从网上查到的
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

		if (StringUtils.isEmpty(reqBody))
			return null;

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
