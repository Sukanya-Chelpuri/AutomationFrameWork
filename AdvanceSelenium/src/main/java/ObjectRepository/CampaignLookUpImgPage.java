package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignLookUpImgPage {
	
	public CampaignLookUpImgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Create Campaign...\"]")
	private WebElement campLookUpImg;

	public WebElement getCampLookUpImg() {
		return campLookUpImg;
	}

	public void clickCampLookUp() 
	{
		campLookUpImg.click();
	}
}
