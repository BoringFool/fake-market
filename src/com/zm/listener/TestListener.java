package com.zm.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class TestListener implements HttpSessionListener {

	private  int userNumber = 0;

	
	public TestListener() {

	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		userNumber++;
		arg0.getSession().setAttribute("userNumber", userNumber);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		userNumber--;
		arg0.getSession().setAttribute("userNumber", userNumber);

	}

	
	
	
	
	
}
