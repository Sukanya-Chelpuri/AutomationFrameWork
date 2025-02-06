package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataUsingDataFormatter {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		//read mode
		Sheet sheet = book.getSheet("Sheet");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
//		String data = cell.getStringCellValue();

		//convert the data to string
		
		DataFormatter format = new DataFormatter();
		String stringFormData = format.formatCellValue(cell);
		System.out.println(stringFormData);
	}

}
