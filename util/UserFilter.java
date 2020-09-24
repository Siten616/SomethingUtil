package com.gem.util;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class UserFilter
 */
//@WebFilter("/*")
public class UserFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public UserFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//哪些可以放行,哪些需要拦截,跳转到登录页面
		HttpServletRequest req = (HttpServletRequest) request;
		String pathString = req.getRequestURI();//请求的路径
		if (pathString.endsWith("/header.jsp") || pathString.endsWith("/index.jsp") || pathString.endsWith("/login.jsp")
				|| pathString.endsWith("/index") || pathString.endsWith("/LoginServlet") || pathString.contains("/css/")
				|| pathString.contains("/js/") || pathString.contains("/fonts/") || pathString.contains("/images/")

		) {//可以直接访问,放行

			chain.doFilter(request, response);
		} else {
			//访问其他页面,判断时候已经登录
			Object object = req.getSession().getAttribute("user");
			if (object != null) {
				//直接放行
				chain.doFilter(request, response);
			} else {
				//跳转到登录页面
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}

		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
