package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritingDataIntoPropertiesFile {

	public static void main(String[] args) throws IOException {
		//read mode
		FileInputStream fis = new FileInputStream("C:\\Users\\sukan\\Desktop\\PropertyFile1.properties");
		Properties prop = new Properties();
		
		prop.setProperty("Username", "sukanya");
		prop.setProperty("Password", "Sukanya123####");
		prop.setProperty("Url", "https:://localhost:8888");
		
		//write mode
		FileOutputStream fos= new FileOutputStream("C:\\Users\\sukan\\Desktop\\PropertyFile1.properties");
		prop.store(fos, "Common data");
		
		
		prop.load(fis);
		String UNAME = prop.getProperty("Username");
		String PWD = prop.getProperty("Password");
		String URL = prop.getProperty("Url");
		
		System.out.println(PWD + "\n" + UNAME + "\n" +  URL);
	}

}
