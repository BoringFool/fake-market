package com.zm.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GoodsConInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String url = uri.substring(context.length());
		String username = (String) request.getSession().getAttribute("username");
		String role = (String) request.getSession().getAttribute("rolesname");
		if (username == null) {
			AjaxResponseMethod.rspSend(request, response, "/jsp/login.jsp");
			return false;
		} else if ("管理员".equals(role)) {
			return true;
		}

		if ("/goods/cartShow".equals(url)) {
			if ("游客".equals(role)) {
				AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
				return false;
			} else {
				return true;
			}

		}

		Set<String> businessMan = new HashSet<String>();
		businessMan.add("/goods/delete");
		businessMan.add("/goods/turn");
		businessMan.add("/goods/addgattr");
		businessMan.add("/goods/addg");
		if (businessMan.contains(url) && "商人".equals(role)) {
			businessMan.clear();
			return true;
		} else {
			AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
			businessMan.clear();
			return false;
		}

	}
}
