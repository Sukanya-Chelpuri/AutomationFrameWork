package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignName;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	public void enterCampaignName(String campName) {
		campaignName.sendKeys(campName);
	}
	
	public void clickSaveButton()
	{
		saveBtn.click();
	}
}
