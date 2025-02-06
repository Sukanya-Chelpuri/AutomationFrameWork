package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "productname")
	private WebElement productNameTextFiled;
	
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void enterProductName(String productName)
	{
		productNameTextFiled.sendKeys(productName);
	}
	public void clickSaveBtn() {
		saveBtn.click();
	}
}
