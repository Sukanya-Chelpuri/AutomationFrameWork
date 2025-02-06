
package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartLinks {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		FileInputStream fis = new FileInputStream("C:\\Users\\sukan\\Desktop\\FaceBookData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet1 = book.getSheet("Links");
		for(int i = 0;i < links.size();i++) {

			Row row1 = sheet1.createRow(i);
			Cell cell1 = row1.createCell(0);
			cell1.setCellValue(links.get(i).getAttribute("href"));
		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\sukan\\Desktop\\FaceBookData.xlsx");
		book.write(fos);
		book.close();



	}
}
