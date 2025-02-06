package practice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchFromPDFFile {

	public static void main(String[] args) throws IOException {
		File file = new File("./src/test/resources/Sukanya_ManualTester_Resume.pdf");
		
		PDDocument doc = PDDocument.load(file);
		
		int pages = doc.getNumberOfPages();
		System.out.println("No of pages:"+pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
//		String readData = pdfData.getText(doc);
//		System.out.println(readData);
		
		pdfData.setStartPage(1);
		pdfData.setEndPage(1);
		String readData2 = pdfData.getText(doc);
		System.out.println(readData2);
		

	}

}
