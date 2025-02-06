package Generic_Utilties;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Window_Utility {
	
	public void switchToWindow(WebDriver driver,String windowTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> itr = allWindows.iterator();
		while(itr.hasNext()) {
			String win = itr.next();
			driver.switchTo().window(win);
			if(win.contains(windowTitle)) {
				break;
			}
		}
	}
}
