package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	@DataProvider
	public Object[][] getData() {
//		Object[][] objArr = new Object[2][2];
//		objArr[0][0] = "Bangalore";
//		objArr[0][1] = "Chennai";
//		
//		objArr[1][0] = "Mumbai";
//		objArr[1][1] = "Goa";
		
		String[][] data = {{"Bangalore","Chennai"}, {"Mumbai", "Goa"}};
		return data;
	}
	
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest) {
		System.out.println("Book Tickets from "+src+ " to "+dest);
	}
}
