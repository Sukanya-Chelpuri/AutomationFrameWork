package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
	
	@DataProvider 
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		data[0][0] = 2;
		data[0][1] = 3;
		
		data[1][0] = 4;
		data[1][1] = 5;
		
		data[2][0] = 6;
		data[2][1] = 7;
		
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void getData(int a, int b) {
		int sum = a+b;
		System.out.println("Sum of "+a+ " and "+b+ " is "+sum);
	}
}
