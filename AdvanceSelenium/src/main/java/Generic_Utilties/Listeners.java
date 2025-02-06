package Generic_Utilties;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners implements ITestListener {
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./failedScript.png");
		
		try {
			FileUtils.copyFile(src, dest);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
