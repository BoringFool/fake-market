package com.zm.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zm.model.Roles;
import com.zm.model.User;
import com.zm.service.IUserService;

@WebFilter(filterName = "PageFilter", urlPatterns = "/jsp/*", initParams = {
		@WebInitParam(name = "loginUrl", value = "/jsp/login.jsp"),
		@WebInitParam(name = "loginProcess", value = "jsp/login"), @WebInitParam(name = "encoding", value = "utf-8"),
		@WebInitParam(name = "notCheckURLList", value = "main.jsp,goods.jsp,login.jsp,register.jsp") })
public class PageFilter implements Filter {

	private String currentUrl;
	private FilterConfig config;
	private List<String> notCheckList = new ArrayList<String>();
	private Set<String> customerL = new HashSet<String>();
	private IUserService userService;
	private String nameR;

	public PageFilter() {

	}

	public void destroy() {
		notCheckList.clear();
		customerL.clear();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) response;
		StringBuffer requestUrl = req.getRequestURL();
		currentUrl = requestUrl.substring(requestUrl.lastIndexOf("/")+1);
		if (notCheckList.contains(currentUrl)) {
			chain.doFilter(req, rsp);
			return;
		} else {
			String userName = (String) req.getSession().getAttribute("username");
			if (userName != null) {
				User u = userService.getByName(userName);
				Iterator<Roles> it = u.getRoles().iterator();
				// 因为我确定只有一个角色，所以用string接收
				while (it.hasNext()) {
					nameR = it.next().getName();
				}
			} else {
				rsp.sendRedirect(req.getContextPath() + config.getInitParameter("loginUrl"));
				return;
			}
		}

		if (rightContains(nameR)) {
			chain.doFilter(req, rsp);
			return;
		} else {
			rsp.sendRedirect(req.getContextPath() + "/jsp/noRight.jsp");
			return;
		}

	}

	private boolean rightContains(String name) {

		customerL.add("cartShow.jsp");
		customerL.add("manager.jsp");
		customerL.add("addAttr.jsp");
		customerL.add("user.jsp");
		if (name.equals("管理员")) {
			return true;
		} else if (name.equals("商人")) {
			if (currentUrl.equals("user.jsp")) {
				return false;
			} else {
				return true;
			}
		} else if (name.equals("顾客")) {
			if (customerL.contains(name)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 获取配置文件，这里是注解里面的参数
		this.config = fConfig;
		// 获取service
		ServletContext context = config.getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		userService = (IUserService) ctx.getBean("userservice");
		String not = config.getInitParameter("notCheckURLList");
		if (not != null) {
			String[] notCheck = not.split(",");
			for (int i = 0; i < notCheck.length; i++) {
				notCheckList.add(notCheck[i].trim());
			}
		}

	}

}
