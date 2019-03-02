package com.bjpowernode.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.dao.TaccountDao;
import com.bjpowernode.dao.impl.TaccountDaoImpl;

public class TaccountController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("进入到转账操作");
		
		String zcAccount = request.getParameter("zcAccount");
		String zrAccount = request.getParameter("zrAccount");
		String zzBalanceStr = request.getParameter("zzBalance");
		int zzBalance = Integer.valueOf(zzBalanceStr);
		
		/*
		 *  1.	判断转出账号有没有
			2.	判断转入账号有没有
			3.	根据转出账号取得转出账号的余额,看看钱够不够
			4.	转出账号扣钱
			5.	根据转入账号取得转入账号的余额
			6.	转入账号加钱


		 */
		
		TaccountDao taccountDao = new TaccountDaoImpl();
		//1.判断转出账号有没有
		if(taccountDao.checkAccount(zcAccount)){
			//2.判断转入账号有没有
			if(taccountDao.checkAccount(zrAccount)){
				
				//3.根据转出账号取得转出账号的余额,看看钱够不够
				int zcBalance = taccountDao.getBalanceByAccount(zcAccount);
				if(zcBalance >= zzBalance){
					
					//4.转出账号扣钱
					taccountDao.updateBalanceByAccount(zcAccount,zcBalance-zzBalance);
					
					//5.根据转入账号取得转入账号的余额
					int zrBalance = taccountDao.getBalanceByAccount(zrAccount);
					
					//6.转入账号加钱
					taccountDao.updateBalanceByAccount(zrAccount, zrBalance+zzBalance);
					
				}
				
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/success.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}

























