package com.OrganizationModule.testcases;

import org.testng.annotations.Test;

@Test(retryAnalyzer= com.vtigerGenericUtil.RetryAnalyzer.class)
public class SampleRetryAnalyzer {
	
	public void retryAnalyzerTest()
	{
		System.out.println(10/0);
	}


}
