package com.bjpowernode.service.impl;

import com.bjpowernode.dao.impl.TaccountDaoImpl;
import com.bjpowernode.service.TaccountService;

public class TaccountServiceImple implements TaccountService {

	@Override
	public void taccountService(String outaccount, String inaccount, String zzbalance) {
		int balance = Integer.valueOf(zzbalance);
		TaccountDaoImpl tdi = new TaccountDaoImpl();
		if(tdi.checkAccount(outaccount)){
			if(tdi.checkAccount(inaccount)){
				int outbalance = tdi.getBalanceByAccount(outaccount);
				if(outbalance >= balance){
					tdi.updateBalanceByAccount(outaccount, outbalance-balance);
					tdi.updateBalanceByAccount(inaccount, balance+tdi.getBalanceByAccount(inaccount));
				}
			}
		}

	}

}
