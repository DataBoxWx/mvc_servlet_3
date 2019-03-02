package com.bjpowernode.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FilterEncoding implements Filter {

   
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = request.getServletPath();
		if("/login.do".equals(path) || "/usernamejudge.do".equals(path)){
			chain.doFilter(req, resp);			
		}else {
			String username = (String) request.getSession().getAttribute("username");
			if(username != null){
				chain.doFilter(req, resp);
			}else {
				response.sendRedirect(request.getContextPath()+"/login.do");	
			}
		}
	}
}
