package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.Methods;

public class DebugExample2 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		 Methods element = new Methods();
		 element.maximizeWindow(driver);
		 
		 driver.get("https://www.flipkart.com/");
		 driver.findElement(By.name("q")).sendKeys("Shoes");
	}
}