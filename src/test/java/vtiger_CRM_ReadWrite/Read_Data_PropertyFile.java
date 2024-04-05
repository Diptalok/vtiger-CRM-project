package vtiger_CRM_ReadWrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Data_PropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		
	}

}
