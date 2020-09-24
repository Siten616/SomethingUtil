package com.gem.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class WebPathList
 *
 */
@WebListener
public class WebPathList implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public WebPathList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//项目关闭,服务器移除项目或者服务器关闭
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 * 项目启动,获得项目路径,放置到applicaition域,以后整个项目中所有的页面都能获得该路径
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//项目启动
		//servletContext(servlet)  相当于 application(jsp)
		ServletContext context = sce.getServletContext();
		//获得项目的访问路径
		String path = context.getContextPath();
		//所有页面都能获得(application,也就是自己中)
		context.setAttribute("basepath", path);
	}

}
