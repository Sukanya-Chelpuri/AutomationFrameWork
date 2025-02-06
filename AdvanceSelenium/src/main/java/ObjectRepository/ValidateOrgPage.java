package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateOrgPage {
	public ValidateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgName;

	public String validateOrgDetails()
	{
		return orgName.getText();
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		System.out.println("Entered data: "+actData);
//		if (actData.contains(OrgName)) {
//			System.out.println("Organization Name is Created");
//		} else {
//			System.out.println("Organization name is not created");
//		}
	}
}
