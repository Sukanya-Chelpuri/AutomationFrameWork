package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpImgPage {
	
	public OrgLookUpImgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt='Create Organization...']")
	private WebElement orgLoopUp;

	//getter method
	public WebElement getOrgLoopUp() {
		return orgLoopUp;
	}
	
	public void clickOrgLookUp()
	{
		orgLoopUp.click();
	}
}
