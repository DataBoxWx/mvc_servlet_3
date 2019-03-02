package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet1");
		
		/*
		 * 当servlet处理完请求后
		 * 我们以前对于浏览器的响应方式很单一,响应流的形式
		 * 
		 * 现在我们可以在请求处理完毕之后,跳转到其他的资源
		 * 我们使用转发和重定向的技术
		 * 
		 */
		
		/*
		 * 转发:
		 * 	语法:
		 * 		1.取得转发对象
		 * 			RequestDispatcher rd = request.getRequestDispatcher("");
		 * 			方法中的参数,为我们设置跳转的路径
		 * 			路径的写法:
		 * 				使用的是不加 /项目名的绝对路径(内部路径)
		 * 				
		 * 
		 * 		2.通过转发对象转发到指定资源
		 * 			rd.forward(request, response)
		 * 
		 * 		
		 * 		注意:
		 * 			转发后,路径保持不变,仍然是以前的路径
		 * 
		 * 
		 */
		
		//1.转发到一个普通的html页面
		/*RequestDispatcher rd = request.getRequestDispatcher("/test1.html");
		rd.forward(request, response);*/
		//request.getRequestDispatcher("/test1.html").forward(request, response);
		
		
		//2.转发到WEB-INF下的html
		/*
		 * 使用转发的形式能够访问到WEB-INF下的资源
		 * 转发也是唯一能够访问到WEB-INF下的资源的方式
		 * 
		 * 在分析原理之前,可以这样来记住
		 * 我们以前直接访问不行,是因为访问路径上出现了WEB-INF这几个字符
		 * 转发之所以可以,是因为路径还是原来的路径,没有出现WEB-INF这几个字符
		 * 
		 */
		//request.getRequestDispatcher("/WEB-INF/html/test1.html").forward(request, response);
		
		
		//3.转发到其他的servlet
		request.getRequestDispatcher("/myServlet2.do").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
















