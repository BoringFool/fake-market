package com.zm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.model.User;
import com.zm.myuntil.FileUpload;
import com.zm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private IUserService userservice;

	@RequestMapping("/register")
	@ResponseBody
	public Long register(@RequestBody User u) {
		User user = userservice.getByName(u.getName());
		if (user == null) {
			userservice.save(u);
			return 1l;
		} else {
			return 0l;
		}
	}
	
	@RequestMapping("checkState")
	@ResponseBody
	public String checkState(HttpServletRequest req) {
		if(req.getSession().getAttribute("username")!=null) {
			return "1";
		}else {
			return "0";
		}
	}

	/*
	 * login判断
	 */
	@RequestMapping("/in")
	@ResponseBody
	public Long in(@RequestBody User u, HttpServletRequest req) {
		Long tof;
		User user = userservice.getByName(u.getName());
		if (user == null) {
			return tof = 3l;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				tof = 1l;
				req.getSession().setAttribute("logoin", "ok");
				req.getSession().setAttribute("username", u.getName());
			} else {
				tof = 0l;
			}
			return tof;
		}
	}

	// form在succ.jsp中
	@RequestMapping("/upload")
	public String a(HttpServletRequest request) {
		String a = "docFile";
		String b = "image";
		HttpServletRequest req = request;
		FileUpload.picUpdate(a, b, req);
		return "succ";

	}

}
