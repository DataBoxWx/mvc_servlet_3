package com.bjpowernode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest request =  (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String login = request.getServletPath();
		if("/login.do".equals(login)){
			chain.doFilter(req, resp);
		}else {
			HttpSession session = request.getSession();
			 String name = (String)session.getAttribute("user");
			if(name != null){
				chain.doFilter(req, resp);
			}else {
				response.sendRedirect(request.getContextPath() +"/login.html");
			}
		}
	}

}
