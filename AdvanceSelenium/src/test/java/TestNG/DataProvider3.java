package TestNG;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 import Generic_Utilties.Excel_Utility;
import Generic_Utilties.File_Utility;
import Generic_Utilties.Java_Utility;
import Generic_Utilties.WebDriver_Utility;
import ObjectRepository.CreateOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgLookUpImgPage;
import ObjectRepository.ValidateOrgPage;

public class DataProvider3 {
	@DataProvider
	public Object[][] readData() {
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		Object[][] data = new Object[3][3];
		data[0][0] = "AAA" + ranNum;
		data[0][1] = "1234567890";
		data[0][2] = "sukanya@gmail.com";
		
		data[1][0] = "BBB" + ranNum;
		data[1][1] = "1234567890";
		data[1][2] = "sukanya@gmail.com";
		
		data[2][0] = "CCC" + ranNum;
		data[2][1] = "1234567890";
		data[2][2] = "sukanya@gmail.com";
		
		return data;
	}
	
	@Test(dataProvider = "readData")
	public void createOrganization(String orgName, String contact, String email) throws Throwable
	{
		WebDriver_Utility wlib = new WebDriver_Utility();
//		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
//		Excel_Utility elib = new Excel_Utility();
		
		String BROWSER = flib.getKeyAndValuePair("Browser");
		String URL = flib.getKeyAndValuePair("Url");
		String UNAME = flib.getKeyAndValuePair("Username");
		String PWD = flib.getKeyAndValuePair("Password");

		WebDriver driver ;

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

		LoginPage login = new LoginPage(driver);
		login.loginToApp(UNAME, PWD);
		
		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrgLookUpImgPage img = new OrgLookUpImgPage(driver);
		img.clickOrgLookUp();
		
//		int ranNum = jlib.getRandomNum();
		
		//------------------------Reading organization data from excel file ---------------------------
		String ORGNAME = orgName;
		String MOBILE = contact;
		String WEBSITE = email;

		CreateOrgPage page = new CreateOrgPage(driver);
		page.enterOrgDetails(ORGNAME, MOBILE, WEBSITE);
		page.clickSaveButton();
		
		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrgDetails();

		home.logOut();
		
		driver.quit();
	}
}
