package com.OrganizationModule.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtigerGenericUtil.BaseClass;

@Listeners(com.vtigerGenericUtil.ListenerImplement.class)
public class SampleListenerTest extends BaseClass{
	
	@Test
	public void listenerTest()
	{
		//System.out.println(10/0);
	}

}
