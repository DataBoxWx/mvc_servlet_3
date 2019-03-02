package com.bjpowernode.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 创建过滤器的步骤
 * 1.创建一个普通的java类,实现javax.servlet.Filter接口
 * 2.重写doFilter方法
 * 		这方法就是我们的过滤器接收并处理请求的方法,类似于servlet中的doGet/doPost
 * 3.修改方法中的形参变量名
 * 		req resp chain
 * 4.完成方法体
 * 5.完成web.xml中的配置
 * 		配置filter的位置一定是放在所有servlet的上面
 * 6.处理完请求之后,不要忘记将请求放行
 */
public class Filter1 implements Filter{
	
	/*@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("fliter1对象创建了");
		
	}*/
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("进入filter1");
		
		//请求放行
		chain.doFilter(req, resp);
		
		//System.out.println("响应又经过了filter1");
		
	}
	
	/*@Override
	public void destroy() {
		
		System.out.println("filter1对象销毁了");
		
	}*/
	
}

































