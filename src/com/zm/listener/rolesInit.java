package com.zm.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zm.service.IRolesService;

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

	//添加默认roles
	public void contextInitialized(ServletContextEvent sce) {
		IRolesService rolesService = (IRolesService) WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean("rolesservice");
		if(rolesService.findall().size()<=0) {
			rolesService.defaultR();
		};
		
	}

}
