package campaign;

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
import Generic_Utilties.Window_Utility;
import ObjectRepository.CampaignLookUpImgPage;
import ObjectRepository.CreateCampaignPage;
import ObjectRepository.CreateProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUpImgPage;
import ObjectRepository.SearchProduct;
import ObjectRepository.ValidateCampaignPage;
import ObjectRepository.ValidateProductName;

@Listeners(Generic_Utilties.ExtentReportImp.class)
public class CreateCampaignWithProduct extends BaseClass{
	
	@Test(groups = "smokeTest")
	public void createCampaignWithProduct() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		Window_Utility window = new Window_Utility();

		HomePage home = new HomePage(driver);
		//------------------------- Creating product---------------------------
		home.clickPrdLink();
		ProductLookUpImgPage productLookUp = new ProductLookUpImgPage(driver);
		productLookUp.clickProductLookUp();

		int ranNum = jlib.getRandomNum();
		//------------------------Reading product data from excel file ---------------------------

		String PRODUCTNAME = elib.getExcelData("ProductData", 0, 0)+ranNum;
		System.out.println("Product name: "+ PRODUCTNAME);

		CreateProductPage createProd = new CreateProductPage(driver);
		createProd.enterProductName(PRODUCTNAME);
		createProd.clickSaveBtn();

		//--------------------------Redirecting to create Campaign tab----------------------
		home.clickMoreLink();
		home.clickCampLink();
		
		CampaignLookUpImgPage campLookup = new CampaignLookUpImgPage(driver);
		campLookup.clickCampLookUp();	

		//------------------------Reading Campaign data from excel file ---------------------------
		String CAMPNAME = elib.getExcelData("CampaignData", 0, 0) + ranNum;
		
		//------------------------- Creating Campaign---------------------------
		CreateCampaignPage createCamp = new CreateCampaignPage(driver);
		createCamp.enterCampaignName(CAMPNAME);
		
		productLookUp.clickAddProductLookUpImg();
		//----------------- Entering product name----------------
		window.switchToWindow(driver, "Products&action");

		SearchProduct search = new SearchProduct(driver);
		search.searchForProduct(PRODUCTNAME);
		search.selectTheProduct(driver, PRODUCTNAME);

		window.switchToWindow(driver, "Campaigns&action");
		createCamp.clickSaveButton();

		ValidateCampaignPage validateCamp = new ValidateCampaignPage(driver);
		String actData = validateCamp.validateCampDetails();
		Assert.assertEquals(actData, CAMPNAME);
		System.out.println("Campaign name is validated");
		
		ValidateProductName validateProd = new ValidateProductName(driver);
		validateProd.validateProductDetailsInCampaign(driver, PRODUCTNAME);

	}
}
