package practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Generic_Utilties.Excel_Utility;
import Generic_Utilties.File_Utility;
import Generic_Utilties.Java_Utility;
import Generic_Utilties.WebDriver_Utility;
import ObjectRepository.CreateOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgLookUpImgPage;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		
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
		
		int ranNum = jlib.getRandomNum();
		
		//------------------------Reading organization data from excel file ---------------------------
		String ORGNAME = elib.getExcelData("OrganizationData", 0, 0) + ranNum;
		String MOBILE = elib.readExcelDataUsingFormatter("OrganizationData", 0, 1);
		String WEBSITE = elib.readExcelDataUsingFormatter("OrganizationData", 0, 2);

		CreateOrgPage page = new CreateOrgPage(driver);
		page.enterOrgDetails(ORGNAME, MOBILE, WEBSITE);
		page.clickSaveButton();
		
//---------------Switching to create contact tab--------------
		home.clickContactLink();
		

//------------------------Reading Contact data from excel file ---------------------------
		FileInputStream fis2 = new FileInputStream("C:\\Users\\sukan\\Desktop\\ContactDetails.xlsx");
		Workbook book2 = WorkbookFactory.create(fis2);		
		Sheet sheet2 = book2.getSheet("Sheet1");
		Row row2 = sheet2.getRow(0);

		String PREFIX = row2.getCell(0).getStringCellValue();
		String FIRSTNAME = row2.getCell(1).getStringCellValue();
		String LASTNAME = row2.getCell(2).getStringCellValue();
		System.out.println("Contact Name: "+PREFIX+"\t"+FIRSTNAME+"\t"+LASTNAME);
		
		WebElement PronounceSelectDropDown = driver.findElement(By.xpath("//select[@name=\"salutationtype\"]"));
		Select sel = new Select(PronounceSelectDropDown);
		sel.selectByValue(PREFIX);
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
//----------------- Adding Organizations name-------------------
		driver.findElement(By.xpath("//input[@name=\"account_name\"]/..//img[@title=\"Select\"]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		while(itr.hasNext()) {
			String win = itr.next();
			driver.switchTo().window(win);
			if(win.contains("Accounts&action")) {
				break;
			}
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		Set<String> allWindows1 = driver.getWindowHandles();
		Iterator<String> itr1 = allWindows1.iterator();
		
		while(itr1.hasNext()) {
			String win1 = itr1.next();
			driver.switchTo().window(win1);
			if(win1.contains("Contacts&action")) {
				break;
			}
		}
		driver.findElement(By.xpath("//input[@title = 'Save [Alt+S]']")).click();
		
		String actualLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actualLastName.contains(LASTNAME)) {
			System.out.println("Contact name is created");
		}
		else {
			System.out.println("Contact name is not created");
		}
		
		String actualOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actualOrgName.contains(ORGNAME)) {
			System.out.println("Organization name is created");
		}
		else {
			System.out.println("Organization name is not created");
		}
		
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		Thread.sleep(5000);
		driver.quit();
	
	}

}
