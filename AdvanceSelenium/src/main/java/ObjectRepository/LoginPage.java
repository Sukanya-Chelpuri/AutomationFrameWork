package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Element Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Element Declaration
	@FindBy(name = "user_name")
	private WebElement UserTextField;
	
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	@FindBy(name = "user_password")
	private WebElement PasswordTextField;
	
	@FindBy(id  = "submitButton")
	private WebElement LoginButton;
	
	public void loginToApp(String username,String password) {
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}
	           													
}
