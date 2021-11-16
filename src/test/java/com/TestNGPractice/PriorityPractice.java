package com.TestNGPractice;

import org.testng.annotations.Test;

public class PriorityPractice {
	@Test(invocationCount=3)
	public void prorityPractice()
	{
		System.out.println("first");
	}
	@Test
	public void createOrg()
	{
		System.out.println("create org");
	}
	@Test(dependsOnMethods="createOrg")
	public void modifyOrg()
	{
		System.out.println("modify org");
	}
	@Test(dependsOnMethods="modifyOrg")
	public void deleteOrg()
	{
		System.out.println("delete org");
	}

}
