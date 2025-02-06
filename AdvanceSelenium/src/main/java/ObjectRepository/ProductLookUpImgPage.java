package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImgPage {
	
	public ProductLookUpImgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title = 'Create Product...']")
	private WebElement productLookUpImg;
	
	@FindBy(xpath = "//input[@name=\"product_name\"]/..//img[@title=\"Select\"]")
	private WebElement addProductLookUpImg;
	
	public void clickProductLookUp() {
		productLookUpImg.click();
	}
	
	public void clickAddProductLookUpImg() {
		addProductLookUpImg.click();
	}

}
