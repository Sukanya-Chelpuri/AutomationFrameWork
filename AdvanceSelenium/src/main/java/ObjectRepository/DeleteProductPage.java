package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {
	public DeleteProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchProduct;
	
	@FindBy(xpath = "//input[@value=\\\"Delete\\\"]")
	private WebElement deleteButton;
	
	public void searchProduct(String ProductName)
	{
		searchProduct.sendKeys(ProductName);
	}
	
	public void deleteProduct(WebDriver driver, String PRODUCTNAME) throws Throwable
	{
		driver.findElement(By.xpath("//a[text()='"+PRODUCTNAME+"']/../..//input[@name=\"selected_id\"]")).click();
		Thread.sleep(5000);
		deleteButton.click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}


}
