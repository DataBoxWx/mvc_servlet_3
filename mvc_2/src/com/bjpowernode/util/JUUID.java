package com.bjpowernode.util;

import java.util.UUID;

public class JUUID {
	public  static String getId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
