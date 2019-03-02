package com.bjpowernode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.service.TaccountService;
import com.bjpowernode.service.impl.TaccountServiceImpl;
import com.bjpowernode.util.ServiceFactory;
import com.bjpowernode.util.TransactionInvocationHandler;

public class TaccountController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到转账操作");
		
		String zcAccount = request.getParameter("zcAccount");
		String zrAccount = request.getParameter("zrAccount");
		String zzBalanceStr = request.getParameter("zzBalance");
		
		/*TaccountServiceImpl tsi = new TaccountServiceImpl(); 
		TaccountServiceProxy tsp = new TaccountServiceProxy(tsi);
		tsp.taccount(zcAccount, zrAccount, zzBalanceStr);*/
		
		/*TaccountServiceImpl tsi = new TaccountServiceImpl(); 
		TransactionInvocationHandler tih = new TransactionInvocationHandler(tsi);
		//得到的是ls对象
		
		 * 我们以前new出来了一个ls,有一个ls的类(xxxProxy)去接收这个对象
		 * 但是现在我们没有一个ls类来接收ls对象
		 
		TaccountService ts = (TaccountService) tih.getProxy();
		ts.taccount(zcAccount, zrAccount, zzBalanceStr);*/
		
		TaccountService ts = (TaccountService) ServiceFactory.getService(new TaccountServiceImpl());
		ts.taccount(zcAccount, zrAccount, zzBalanceStr);
		
		
		response.sendRedirect(request.getContextPath() + "/success.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























