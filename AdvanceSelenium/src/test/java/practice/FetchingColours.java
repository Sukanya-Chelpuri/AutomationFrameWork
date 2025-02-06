package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FetchingColours {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		 List<WebElement> colours = driver.findElements(By.xpath("//h2[@aria-label=\"Apple iPhone 13 (128GB) - Starlight\"]/../../..//div[@class=\"a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view\"]//a"));
		for(WebElement colour: colours) {
			System.out.println(colour.getAttribute("aria-label"));
		}
		//print the phone names whose price is greater than 50,000
		//print the phone name along with the price
		
			
	}
}
