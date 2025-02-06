package campaign;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilties.BaseClass;
import Generic_Utilties.Excel_Utility;
import Generic_Utilties.File_Utility;
import Generic_Utilties.Java_Utility;
import Generic_Utilties.WebDriver_Utility;
import ObjectRepository.CampaignLookUpImgPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ValidateCampaignPage;


@Listeners(Generic_Utilties.ExtentReportImp.class)

public class CreateCampaign extends BaseClass {

	@Test(retryAnalyzer = Generic_Utilties.RetryImp.class)
	public void createCampaign() throws Throwable {

		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		HomePage home = new HomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		
		CampaignLookUpImgPage campLookup = new CampaignLookUpImgPage(driver);
		campLookup.clickCampLookUp();	
		
		Assert.fail("i am failing the test script");

		int ranNum = jlib.getRandomNum();
		String CampName = elib.getExcelData("CampaignData", 0, 0) + ranNum;
		
		CreateCampaignPage createCamp = new CreateCampaignPage(driver);
		createCamp.enterCampaignName(CampName);
		createCamp.clickSaveButton();
		
		ValidateCampaignPage validate = new ValidateCampaignPage(driver);
		String actData = validate.validateCampDetails();
		Assert.assertEquals(actData, CampName);
		System.out.println("Campaign name is validated");


	}

}