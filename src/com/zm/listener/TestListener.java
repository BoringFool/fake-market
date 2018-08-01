package com.zm.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zm.service.IOrderListService;


@WebListener
public class TestListener implements HttpSessionListener {

	private  int userNumber = 0;

	
	public TestListener() {

	}

	@Override
	public void sessionCreated(HttpSessionEvent sessionevent) {
		userNumber++;
		sessionevent.getSession().setAttribute("userNumber", userNumber);

	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public void sessionDestroyed(HttpSessionEvent sessionevent) {
		HttpSession session=sessionevent.getSession();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
		IOrderListService service = (IOrderListService) applicationContext.getBean("OrderListService");
		if(session.getAttribute("shoppingCart")==null) {
			
		}else {
			Map<Long, Integer> shoppingCart = (HashMap<Long, Integer>)session.getAttribute("shoppingCart");
		}
		

	}

	
	
	
	
	
}
