package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampaignPage {
	public ValidateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement campName;
	
	
	public String validateCampDetails()
	{
		return campName.getText();
//		String actData = campName.getText();
//		if (actData.contains(CampName)) {
//			System.out.println("Campaign name is created");
//		} else {
//			System.out.println("Campaign name is not created");
//		}
		
	}
}
