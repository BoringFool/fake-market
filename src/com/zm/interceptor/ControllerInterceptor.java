package com.zm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ControllerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = uri.substring(contextPath.length());
		String userName = (String) request.getAttribute("username");
		
		System.out.println(url);
		//因为filter只过滤page请求，防止有人直接输入controller请求，所以需要验证登陆
		if (userName == null) {
			AjaxResponseMethod.rspSend(request, response, "/jsp/login.jsp");
			return false;
		} else if (url.equals("/user/register")||url.equals("/user/in")) {
			AjaxResponseMethod.rspSend(request, response, "/jsp/noRight.jsp");
			return false;
		} else {
			return true;
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
