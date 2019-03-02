package com.bjpowernode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.dao.impl.TaccountDaoImpl;
import com.bjpowernode.service.TaccountService;
import com.bjpowernode.service.impl.TaccountServiceImple;
import com.bjpowernode.util.TransactionInvocationHandler;

public class TaccountController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String outaccount = request.getParameter("outaccount");
		String inaccount = request.getParameter("inaccount");
		String zzbalance = request.getParameter("balance");
		/*TaccountServiceImple tsi = new TaccountServiceImple();
		tsi.taccountService(outaccout, inaccount, zzbalance);*/
		
		TaccountServiceImple tsi = new TaccountServiceImple();
		TransactionInvocationHandler tsith = new TransactionInvocationHandler(tsi);
		TaccountService ts = (TaccountService)tsith.getProxy();
		ts.taccountService(outaccount, inaccount, zzbalance);
		
		response.sendRedirect(request.getContextPath() +"/continuetransfer.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
