package com.zm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.model.C;
import com.zm.model.Goods;
import com.zm.myuntil.FileUpload;
import com.zm.myuntil.StringArray;
import com.zm.service.IGoodsService;

@Controller
@RequestMapping("goods")
public class GoodsAction {

	@Resource
	private IGoodsService goodsservice;

	// manager查询展示
	@RequestMapping("query")
	@ResponseBody
	public List<Goods> query(@RequestBody Goods c) {
		int first = (int) ((c.getId() - 1) * 5);
		List<Goods> glist = goodsservice.limitq(first, 5);
		return glist;
	}

	// 模糊查询 同时分页展示
	@RequestMapping("likeLimit")
	@ResponseBody
	public List<Goods> likeRetrieve(@RequestBody Goods g) {
		List<Goods> gl = goodsservice.likeAndLimit(g.getName(), (int) ((g.getId() - 1) * 50), 50);
		return gl;
	}

	@RequestMapping("showquery")
	@ResponseBody
	/*
	 * 查询展示 缺少处理imageUrl的方法，暂时只能使用一个图片地址的imageUrl
	 */
	public List<Goods> showquery(@RequestBody C c, HttpServletRequest req) {
		int first = (c.getA() - 1) * 50;

		List<Goods> glist = goodsservice.limitq(first, c.getB());
		// 把数据存放到session中（goodsList）
		if (req.getSession().getAttribute("goodsList") == null) {
			List<Goods> sessionList = glist;
			req.getSession().setAttribute("goodsList", sessionList);
		} else {
			@SuppressWarnings("unchecked")
			List<Goods> sessionList = (List<Goods>) req.getSession().getAttribute("goodsList");
			// 删除重复元素，因为是代理类，所以得用id来判断
			for (Goods g : glist) {
				Iterator<Goods> it = sessionList.iterator();
				while (it.hasNext()) {
					Goods gg = it.next();
					if (gg.getId() == g.getId()) {
						it.remove();
						break;
					}
				}
			}
			sessionList.addAll(glist);
			req.getSession().setAttribute("goodsList", sessionList);
		}
		return glist;
	}

	@RequestMapping("count")
	@ResponseBody
	// 用来查询总行数，来计算manager页面下方页数显示
	public C count() {
		long count = goodsservice.count();
		C c = new C();
		c.setA((int) count);
		return c;

	}

	@RequestMapping(value = "addg", produces = { "text/html;charset=utf-8" })
	@ResponseBody
	public String addg(@RequestBody Goods c, HttpServletRequest req) {
		String userName = (String) req.getSession().getAttribute("username");
		c.setStore(userName);
		String result = goodsservice.save(userName, c);
		if (result.equals("1")) {
			return "成功";
		} else if (result.equals("2")) {
			return "已存在";
		} else {
			return "管理员不要添加商品";
		}
	}

	@RequestMapping("addgattr")
	@ResponseBody
	// 属性修改
	public String addgattr(@RequestBody Goods g) {

		if (g.getBrand().contains("_")) {
			// 修改已存在属性
			String fix = g.getBrand().substring(1);
			g.setBrand(fix);
			goodsservice.update(g);
			return "1";
		} else {
			// 增加未设置的值
			Goods updateg = goodsservice.getById(g.getId());
			updateg.setBrand(g.getBrand());
			updateg.setColor(g.getColor());
			updateg.setSize(g.getSize());
			updateg.setImageurl(g.getImageurl());
			goodsservice.update(updateg);
			return "1";
		}

	}

	@RequestMapping("getbyid")
	@ResponseBody
	public Goods getById(@RequestBody Goods g) {
		return goodsservice.getById(g.getId());
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(@RequestBody Goods g) {
		goodsservice.delete(g.getId());
		return "1";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("cartShow")
	@ResponseBody
	// session做差了的后果，需要用这个方法来查询
	public List<String[]> show(HttpServletRequest req) {
		List<String[]> go = new ArrayList<>();

		if (req.getSession().getAttribute("shoppingCart") == null) {
			String[] n = { "0", "0", "0", "0", "0" };
			go.add(n);
		} else {
			Map<Long, Integer> shoppingCart = (HashMap<Long, Integer>) req.getSession().getAttribute("shoppingCart");
			Set<Long> key = shoppingCart.keySet();
			for (Long i : key) {
				Goods g = goodsservice.getById(i);
				String[] a = new String[5];
				a[0] = g.getImageurl();
				a[1] = g.getName();
				a[2] = g.getStore();
				a[3] = g.getPrice() + "";
				a[4] = shoppingCart.get(i) + "";
				go.add(a);
			}
		}

		return go;
	}

	@RequestMapping("jsontest")
	@ResponseBody
	// 实验用的方法
	public String testjson(@RequestBody Goods g) {
		String a = g.getImageurl();
		System.out.println(a);
		// 取得数组第一个，因为会抛出异常，所以需要检查结果是否为null
		String s = StringArray.jsonget(g.getImageurl(), 0);
		if (s == null) {
			System.out.println("json字符串有问题，请检查！");
		}
		return "1";
	}

	@RequestMapping("stringtest")
	@ResponseBody
	// 实验用的方法
	public Goods stringjson(@RequestBody Goods g) {
		String b = g.getName();
		System.out.println(b);
		System.out.println(StringArray.stringToArray(b) + "\n输出的是数组\n");
		System.out.println(StringArray.ArrayToString(StringArray.stringToArray(b)) + "\n输出的string\n");

		Goods ngood = new Goods();
		ngood.setName(StringArray.ArrayToString(StringArray.stringToArray(b)));
		return ngood;
	}

	@RequestMapping("turn")
	// 上传文件
	public String turn(HttpServletRequest request) {
		String a = "docFile";
		String b = "image";
		/*
		 * 
		 * 不知道什么原因，直接以request为参数会报错 The method picUpdate(String, String,
		 * HttpServletRequest) in the type FileUpload is not applicable for the
		 * arguments (HttpServletRequest)
		 * 
		 */
		HttpServletRequest req = request;
		String newName = FileUpload.picUpdate(a, b, req);
		Goods g = goodsservice.getById(Integer.parseInt(req.getParameter("hid")));
		g.setImageurl("../image/" + newName);
		goodsservice.update(g);
		return "manager";
	}

}
