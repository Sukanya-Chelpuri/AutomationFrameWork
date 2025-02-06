package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\sukan\\Desktop\\PropertyFile1.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String BROWSER = prop.getProperty("Browser");
//		String UNAME = prop.getProperty("Username");
//		String PWD = prop.getProperty("Password");
//		String URL = prop.getProperty("Url");
		prop.setProperty("Key1", "value1");
		
		WebDriver driver ;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(UNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PWD);
//		driver.findElement(By.id("submitButton")).click();
		
		driver.quit();
		
	}
}
