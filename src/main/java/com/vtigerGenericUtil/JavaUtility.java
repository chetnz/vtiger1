package com.vtigerGenericUtil;

import java.util.Random;

public class JavaUtility {

	public static int randomNum()
	{
		Random r = new Random();
		int num = r.nextInt(1000);
		return num;
	}
}
