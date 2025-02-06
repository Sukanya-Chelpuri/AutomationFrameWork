package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImgPage {
 public ContactLookUpImgPage(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
 }
 
}
