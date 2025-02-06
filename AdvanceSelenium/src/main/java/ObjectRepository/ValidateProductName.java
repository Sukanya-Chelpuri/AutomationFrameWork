package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateProductName {
	
	public ValidateProductName(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement actualNameOfProduct;
	
	@FindBy(id = "mouseArea_Product")
	private WebElement actualNameOfPrdInCamp;
	
	public String validateProdDetails(WebDriver driver, String ProductName) {
		
		return actualNameOfProduct.getText();
//		System.out.println("Actual name "+actualNameOfProduct.getText());
//		if(actualNameOfProduct.getText().contains(ProductName)) {
//			System.out.println("Product name is created");
//		}
//		else {
//			System.out.println("Product name is not created");
//		}	
	}
	
	public String validateProductDetailsInCampaign(WebDriver driver,String productName) {
		return actualNameOfPrdInCamp.getText();
		
//		System.out.println("Actual name "+actualNameOfPrdInCamp.getText());
//		if(actualNameOfPrdInCamp.getText().contains(productName)) {
//			System.out.println("Product name is created");
//		}
//		else {
//			System.out.println("Product name is not created");
//		}
	}
}
