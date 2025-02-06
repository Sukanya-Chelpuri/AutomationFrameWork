package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;


public class HardAssertion {
	@Test
	public void method1() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals("A", "A");
		System.out.println("Step 3");
		System.out.println("Step 4");

	}

	@Test
	public void method2() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		Assert.assertEquals("A", "B");
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	
	@Test
	public void method3() {
		String actData = "Sukanya";
		String expData = "sukanya";
		Assert.assertEquals(actData, expData);
	}
	
	@Test
	public void method4() {
		int a =10;
		int b = 20;
		Assert.assertEquals(a, b, "Values are not equal");
		System.out.println("Values are equal");
	}
	
	@Test
	public void method5() {
		int a =10;
		int b = 10;
		Assert.assertEquals(a, b, "Values are not equal");
		System.out.println("Values are equal");
	}
}
