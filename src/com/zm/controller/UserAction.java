package com.zm.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.model.Roles;
import com.zm.model.User;
import com.zm.myuntil.FileUpload;
import com.zm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Resource
	private IUserService userservice;

	@RequestMapping("showall")
	@ResponseBody
	public List<User> showAll() {
		return userservice.findall();
	}

	@RequestMapping("likesearch")
	@ResponseBody
	public List<User> likeSearch(@RequestParam("wo") boolean whichO, @RequestParam("key") String key) {
		return userservice.likeSearch(whichO, key);
	}

	@RequestMapping("delete")
	@ResponseBody
	public Integer delete(@RequestParam("id") long id) {
		userservice.delet(id);
		return 1;
	}

	@RequestMapping("authorize")
	@ResponseBody
	public Integer authorize(@RequestBody Map<String, String> m, HttpServletRequest req) {
		String id = m.get("id");
		String role = m.get("roles");
		userservice.rolesSave(Long.parseLong(id), role);
		// 覆盖session中的rolesName，被用于拦截器判断
		req.getSession().setAttribute("rolesname", role);
		return 1;
	}

	@RequestMapping("/register")
	@ResponseBody
	public Long register(@RequestBody User u) {

		return userservice.save(u);

	}

	@RequestMapping("checkState")
	@ResponseBody
	public String checkState(HttpServletRequest req) {
		if (req.getSession().getAttribute("username") != null) {
			return "1";
		} else {
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
		String rolesName = null;
		User user = userservice.getByName(u.getName());
		if (user == null) {
			return tof = 3l;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				tof = 1l;
				req.getSession().setAttribute("logoin", "ok");
				req.getSession().setAttribute("username", u.getName());
				// u是瞬时状态，所以没有roles，user是持久的，所以用user来获取。
				Iterator<Roles> it = user.getRoles().iterator();
				while (it.hasNext()) {
					Roles r = it.next();
					rolesName = r.getName();
					break;
				}
				req.getSession().setAttribute("rolesname", rolesName);
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
