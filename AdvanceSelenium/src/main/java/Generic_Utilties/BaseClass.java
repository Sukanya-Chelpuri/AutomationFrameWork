package Generic_Utilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;

	File_Utility flib = new File_Utility();
	WebDriver_Utility wlib = new WebDriver_Utility();

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS() {
		System.out.println("Database connection");
	}

	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT() {
		System.out.println("Parallel execution start");
	}

	//	@Parameters("BROWSER") --------- To read data from xml file
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	//	public void BC(String BROWSER) throws Throwable {

	public void BC() throws Throwable{
		String BROWSER = flib.getKeyAndValuePair("Browser");
		String URL = flib.getKeyAndValuePair("Url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}

		sdriver = driver;
		driver.get(URL);

		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM() throws Throwable {
		System.out.println("Logging in to App");
		LoginPage login = new LoginPage(driver);
		String UNAME = flib.getKeyAndValuePair("Username");
		String PWD = flib.getKeyAndValuePair("Password");
		login.loginToApp(UNAME, PWD);
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM() {
		System.out.println("Logging out from App");
		HomePage home = new HomePage(driver);
		home.logOut();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC() {
		driver.quit();
	}

	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT() {
		System.out.println("Parallel execution end");
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS() {
		System.out.println("Database connect closed");
	}
}
