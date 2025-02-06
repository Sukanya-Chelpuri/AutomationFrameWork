package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\sukan\\Desktop\\ExcelFile1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet1 = book.getSheet("Sheet");
		Row row1 = sheet1.createRow(5);
		Cell cell1 = row1.createCell(5);
		cell1.setCellValue("Sukanya");
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\sukan\\Desktop\\ExcelFile1.xlsx");
		book.write(fos);
		book.close();

	}
}
