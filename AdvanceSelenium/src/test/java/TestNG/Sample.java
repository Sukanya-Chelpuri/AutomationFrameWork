package TestNG;

import org.testng.annotations.Test;

public class Sample {
	
//	@Test(priority = 0)
//	public void createContact()
//	{
//
//	System.out.println("contact created");
//
//	}
//    @Test(priority = -1)
//	public void modifyContact()
//	{
//		System.out.println("modify contact");
//	}
//	
//	@Test(priority = 1)
//	public void deleteContact()
//	{
//		System.out.println("delete contact");
//	}
//	
	@Test(invocationCount = 2)
	public void createContact()
	{

	System.out.println("contact created");

	}

	@Test(dependsOnMethods = "createContact", enabled = false)
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
