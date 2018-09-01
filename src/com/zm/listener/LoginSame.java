package com.zm.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginSame
 *
 */
@WebListener
public class LoginSame implements HttpSessionAttributeListener, HttpSessionListener {
	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	// 属性增加
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		if ("username".equals(name)) {
			String userName = (String) arg0.getValue();
			if (map.get(userName) != null) {
				HttpSession session = map.get(userName);
				session.removeAttribute("username");
			}
			map.put((String) arg0.getValue(), arg0.getSession());
		}
	}

	// 属性删除
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		if (name.equals("username")) {
			String ub = (String) arg0.getValue();
			map.remove(ub);
		}
	}

	// 属性替换
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		String name = arg0.getName();
		if (name.equals("username")) {
			// 看API就知道了
			String oldUserName = (String) arg0.getValue();
			map.remove(oldUserName);
			String userName = (String) arg0.getSession().getAttribute("username");
			if (map.get(userName) != null) {
				// map中有记录，表明该帐号在其他机器上登录过，将之前的登录失效
				HttpSession session = map.get(userName);
				session.removeAttribute("username");
			}
			map.put(userName, arg0.getSession());
			
			Set<String> s=map.keySet();
			Iterator<String> it=s.iterator();
			while (it.hasNext()) {
				String key=it.next();
				System.out.println(map.get(key)+"***********************************");
			}
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSessionListener.super.sessionCreated(se);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		try {
			String userName = (String) se.getSession().getAttribute("username");
			map.remove(userName);
		} catch (Exception e) {
			System.out.println("当前session没有登陆！");
		}
	}

}
