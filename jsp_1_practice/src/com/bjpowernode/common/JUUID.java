package com.bjpowernode.common;

import java.util.UUID;

public class JUUID {
	     public static String getUUId() {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
}
