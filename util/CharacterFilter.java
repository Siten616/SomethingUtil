package com.gem.util;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

//处理servlet中的中文乱码

/**
 * Servlet Filter implementation class CharacterFiter
 */
//拦截的路径，拦截谁就填谁的路径，拦截所有的请求和响应
@WebFilter("/*")
public class CharacterFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public CharacterFilter() {
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
	//拦截下来之后执行的操作
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//统一处理中文编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//chain过滤器链
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
