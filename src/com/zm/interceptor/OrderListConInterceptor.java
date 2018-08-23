package com.zm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class OrderListConInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String userName = (String) request.getSession().getAttribute("username");
		String role = (String) request.getSession().getAttribute("rolesname");

		if (userName == null) {
			AjaxResponseMethod.rspSend(request, response, "/jsp/login.jsp");
			return false;
		} else if ("游客".equals(role)) {
			AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
			return false;
		} else {
			return true;
		}

	}
}
