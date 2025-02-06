package Generic_Utilties;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriver_Utility {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public static String takeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {

		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	} 

}
