package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	
	public SearchProduct(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_txt")
	private WebElement searchTextField;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public void searchForProduct(String productName) 
	{
		searchTextField.sendKeys(productName);
		searchBtn.click();
	}
	
	public void selectTheProduct(WebDriver driver,String productName) {
		driver.findElement(By.linkText(productName)).click();
	}
	
	
	
}
