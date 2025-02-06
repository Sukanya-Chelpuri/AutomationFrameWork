package ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateDeleteProductPage {
	public ValidateDeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr/td[3]")
	private List<WebElement> productList;

	public void validateDeleteProduct(String productData) {
		boolean flag = false;

		for (WebElement prdName : productList)
		{
			String actData = prdName.getText();
			if(actData.contains(productData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("product data is deleted");
		}
		else
		{
			System.out.println("product data is not deleted");
		}

	}

}
