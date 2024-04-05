package LeadModule_Framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_File {
	
	public String ReadPropertydata(String  key) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\LeadFiles\\Propertyfile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	public String ReadExcelData(String sname, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\LeadFiles\\lead.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sname);
		String val = sheet.getRow(row).getCell(cell).getStringCellValue();
		return val;
	}

}
