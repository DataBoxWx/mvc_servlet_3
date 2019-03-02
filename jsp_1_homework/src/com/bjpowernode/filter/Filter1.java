package com.bjpowernode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter1 implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String path = request.getServletPath();
		if("/login.do".equals(path)){
			chain.doFilter(req, resp);
		}else {
			String user = (String) request.getSession().getAttribute("username");
			if(user != null){
				chain.doFilter(req, resp);
			}else {
				response.sendRedirect(request.getContextPath() + "/login.do");
			}
		}
	}

}
