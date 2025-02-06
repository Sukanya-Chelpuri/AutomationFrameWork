package organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilties.BaseClass;
import Generic_Utilties.Excel_Utility;
import Generic_Utilties.File_Utility;
import Generic_Utilties.Java_Utility;
import Generic_Utilties.RetryImp;
import Generic_Utilties.WebDriver_Utility;
import ObjectRepository.CreateOrgPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgLookUpImgPage;
import ObjectRepository.ValidateOrgPage;

@Listeners(Generic_Utilties.ExtentReportImp.class)
public class CreateOrganization extends BaseClass{

	@Test(groups = {"smokeTest","regressionTest"})
	public void createOrganization() throws Throwable {
		
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
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
		
		ValidateOrgPage validate = new ValidateOrgPage(driver);
		String actData = validate.validateOrgDetails();
		Assert.assertEquals(actData, ORGNAME);
		System.out.println("Organization name is validated");

	}
}
