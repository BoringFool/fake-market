package com.zm.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//MVC没有配置，不生效
public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if ("GET".equalsIgnoreCase(request.getMethod())) {
			
		}

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());

		if ("/userController/login".equals(url)) {
			return true;
		} else {
			String username = (String) request.getSession()
					.getAttribute("username");
			if (username == null) {
				request.getRequestDispatcher("/jsp/login.jsp").forward(
						request, response);
				//结果:http://localhost:8080/market/jsp/login.jsp
				
				
				
				/* 
				 *  http://localhost:8080/market/user/in
				 *	因为是拦截的controller，所以路径用绝对路径。用相对路径如下：
				 *  request.getRequestDispatcher("login.jsp").forward(request, response);
				  *    结果：http://localhost:8080/market/user/login.jsp
				  *    会是错误的。
				 * */
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) { // 加入当前时间
			modelAndView.addObject("haha", "测试postHandle");
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
}
