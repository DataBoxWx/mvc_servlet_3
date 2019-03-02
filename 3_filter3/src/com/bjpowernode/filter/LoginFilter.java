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
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("进入到验证有没有登录的过滤器");
		
		/*
		 * 我们现在需要使用HttpServletRequest调用getSession方法来取得session
		 * 
		 * 我们没有HttpServletRequest对象 儿子
		 * 
		 * 但是我们有ServletRequest对象 父亲
		 * 
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//如果请求为/login.do则自动放行
		String path = request.getServletPath();
		System.out.println(path);
		
		//对于login.do的处理
		if("/login.do".equals(path)){
			chain.doFilter(req, resp);
		
		
		//对于其他.do的处理
		}else{
			
			
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			
			//登录过
			if(username!=null){
				
				chain.doFilter(req, resp);
			
			//没登录过
			}else{
				
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				
			}
			
			
			
			
		}
		
		
		
		
		
	}

}























