package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFacebookData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\sukan\\Desktop\\FaceBookData.xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Links");
		int noOfRows = sheet.getLastRowNum();
		System.out.println(noOfRows);

		for (int i=0;i<=noOfRows;i++)
		{
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String value = cell.getStringCellValue();
			System.out.println(value);
		}
	}
}
