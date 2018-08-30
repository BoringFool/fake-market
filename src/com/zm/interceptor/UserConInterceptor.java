package com.zm.interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserConInterceptor extends HandlerInterceptorAdapter {

	public final static List<String> NEEDURL = Arrays.asList("/user/getbyname", "/user/checkpassword");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String userName = (String) request.getSession().getAttribute("username");
		String rolesName = (String) request.getSession().getAttribute("rolesname");

		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String url = uri.substring(context.length());
		StringBuffer juge = request.getRequestURL();

		if (url.equals("/user/signout")) {
			return true;
		}
		
		// 因为filter只过滤page请求，防止有人直接输入controller请求，所以需要验证登陆
		if (userName == null) {
			AjaxResponseMethod.rspSend(request, response, "/jsp/login.jsp");
			return false;
		} else if (rolesName.equals("管理员")) {
			return true;
		} else if (rolesName.equals("顾客") || rolesName.equals("商人")) {
			// 嵌套判断有点多
			if (juge.indexOf("?") != 0) {
				String[] argName = request.getRequestURL().toString().split("=");
				if (argName[1].equals(userName)) {
					return true;
				} else {
					AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
					return false;
				}
			} else if (NEEDURL.contains(url)) {
				return true;
			}

			AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
			return false;
		} else {
			AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
