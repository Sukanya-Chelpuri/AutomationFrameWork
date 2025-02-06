package product;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilties.BaseClass;
import Generic_Utilties.Excel_Utility;
import Generic_Utilties.File_Utility;
import Generic_Utilties.Java_Utility;
import Generic_Utilties.WebDriver_Utility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DeleteProductPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.ProductLookUpImgPage;
import ObjectRepository.ValidateDeleteProductPage;
import ObjectRepository.ValidateProductName;

public class DeleteProduct extends BaseClass {
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void deleteProduct() throws Throwable {

		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		
		HomePage home = new HomePage(driver);
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
		ValidateProductName validate = new ValidateProductName(driver);
		validate.validateProdDetails(driver, PRODUCTNAME);
	
///-----------------------------Deleting the product---------------------
	
		home.clickPrdLink();
		DeleteProductPage delete = new DeleteProductPage(driver);
		delete.searchProduct(PRODUCTNAME);
		delete.deleteProduct(driver, PRODUCTNAME);
		
		ValidateDeleteProductPage validateDelete = new ValidateDeleteProductPage(driver);
		validateDelete.validateDeleteProduct(PRODUCTNAME);

	}
}
