package com.zm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zm.model.Roles;
import com.zm.model.User;
import com.zm.service.IRolesService;
import com.zm.service.IUserService;

/**
 * Application Lifecycle Listener implementation class rolesInit
 *
 */
@WebListener
public class rolesInit implements ServletContextListener {
	public rolesInit() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	// 添加默认roles,同时添加一个默认admit账户
	public void contextInitialized(ServletContextEvent sce) {
		IRolesService rolesService = (IRolesService) WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext()).getBean("rolesservice");
		IUserService userService = (IUserService) WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext()).getBean("userservice");

		if (rolesService.findall().size() <= 0) {
			rolesService.defaultR();
		}
		;
		User u = userService.getByName("admit");
		if (u == null) {
			Roles r = rolesService.getById(1l);
			User user = new User();
			user.setName("admit");
			user.setPassword("admit");
			user.setEmail("admit");
			user.getRoles().add(r);
			userService.save(user);
		}

	}

}
