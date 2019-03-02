package com.bjpowernode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter4 implements Filter{
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("进入filter4");
		
		//请求放行
		chain.doFilter(req, resp);
		
		System.out.println("响应又经过了filter4");
		
	}
	
}

































