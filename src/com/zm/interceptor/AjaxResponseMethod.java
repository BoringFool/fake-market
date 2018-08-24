package com.zm.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * AJAX无法重定向，不支持页面重新加载，定义该方法来解决。需要在所有AJAX上面加上
 * complete属性来跳转页面
 * */
public class AjaxResponseMethod {

	/*
	 * 1.request.getSchema() 可以返回当前页面使用的协议，HTTP 或是 HTTPS; 2.request.getServerName()
	 * 可以返回当前页面所在的服务器的名字; 3.request.getServerPort() 可以返回当前页面所在的服务器使用的端口;
	 * 4.request.getContextPath() 可以返回当前页面所在的应用的名字;
	 */
	public static void rspSend(HttpServletRequest req, HttpServletResponse rsp, String goWhere) throws IOException {
		// 获取当前请求的路径
		String basePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
				+ req.getContextPath();
		/*
		 * 如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是AJAX请求，需要特殊处理
		 * 否则直接重定向就可以了
		 */
		if ("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))) {
			// 告诉AJAX我是重定向
			rsp.setHeader("REDIRECT", "REDIRECT");
			// 告诉AJAX我重定向的路径
			rsp.setHeader("CONTEXTPATH", basePath + goWhere);
			// 服务器理解请求，拒绝处理
			rsp.setStatus(HttpServletResponse.SC_FORBIDDEN);
		} else {
			rsp.sendRedirect(basePath + goWhere);
		}
	}
}
