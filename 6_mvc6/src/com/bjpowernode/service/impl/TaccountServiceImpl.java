package com.bjpowernode.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.bjpowernode.dao.TaccountDao;
import com.bjpowernode.dao.impl.TaccountDaoImpl;
import com.bjpowernode.service.TaccountService;
import com.bjpowernode.util.DBUtil;

public class TaccountServiceImpl implements TaccountService {

	@Override
	public void taccount(String zcAccount, String zrAccount, String zzBalanceStr) {
		
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
		
		System.out.println("进入到处理转账业务");
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
			
			
		
		
		

	}

}
