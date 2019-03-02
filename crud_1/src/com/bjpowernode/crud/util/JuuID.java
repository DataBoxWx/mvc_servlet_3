package com.bjpowernode.crud.util;

import java.util.UUID;

public class JuuID {
	public static String getIdd(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
